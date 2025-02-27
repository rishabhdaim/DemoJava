/**
 * 
 */
package demo.java8.tutorialpoints.spring.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import demo.java8.tutorialpoints.spring.annotation.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import demo.java8.tutorialpoints.spring.jdbc.tx.StudentMarks;
import demo.java8.tutorialpoints.spring.jdbc.tx.StudentMarksMapper;

/**
 * @author Rishabh.Daim
 *
 */
public class StudentJDBCTemplate implements StudentDAO {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcCall jdbcCallProc;
	private final SimpleJdbcCall jdbcCallFunc;
	private final PlatformTransactionManager platformTransactionManager;

	public StudentJDBCTemplate(final DataSource dataSource, final PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setResultsMapCaseInsensitive(true);
		this.jdbcCallProc = new SimpleJdbcCall(dataSource).withProcedureName("GETSTUDENT");
		this.jdbcCallFunc = new SimpleJdbcCall(dataSource).withFunctionName("GETSTUDENTNAME").withSchemaName("rkdaim");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#create(java.lang.String,
	 * java.lang.Integer)
	 */
	@Override
	public void create(String name, Integer age) {
		final String sql = "insert into Student (name, age) values (?, ?)";
		jdbcTemplate.update(sql, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
	}
	
	/*
	 * (non-Javadoc)
	 * @see tutorialpoints.spring.jdbc.StudentDAO#create(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		final TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			String sql1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplate.update(sql1, name, age);

			// Get the latest student id to be used in Marks table
			String sql2 = "select max(id) from Student";
			int sid = jdbcTemplate.queryForObject(sql2, int.class);

			String sql3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
			jdbcTemplate.update(sql3, sid, marks, year);

			System.out.println("Created Name = " + name + ", Age = " + age);
			platformTransactionManager.commit(status);
		} catch (DataAccessException e) {
			System.err.println("Error in creating record, rolling back");
			platformTransactionManager.rollback(status);
			throw e;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see tutorialpoints.spring.jdbc.StudentDAO#createAopTx(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void createAopTx(String name, Integer age, Integer marks, Integer year) {
		try {
			String sql1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplate.update(sql1, name, age);

			// Get the latest student id to be used in Marks table
			String sql2 = "select max(id) from Student";
			int sid = jdbcTemplate.queryForObject(sql2, int.class);

			String sql3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
			jdbcTemplate.update(sql3, sid, marks, year);

			System.out.println("Created Name = " + name + ", Age = " + age);
			
			// to simulate the exception.
	        throw new RuntimeException("simulate Error condition") ;
		} catch (Exception e) {
			System.err.println("Error in creating record, rolling back");
			throw e;
         }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#getStudent(java.lang.Integer)
	 */
	@Override
	public Student getStudent(Integer id) {
		/*String sql = "select * from Student where id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new Object[] { id }, new StudentMapper());*/
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("IN_ID", id);
		Map<String, Object> result = jdbcCallProc.execute(in);
		
		Student student = new Student();
		student.setId(id);
		student.setName((String) result.get("OUT_NAME"));
		student.setAge(((BigDecimal)result.get("OUT_AGE")).intValueExact());
		
		return student;
	}
	
	/*
	 * (non-Javadoc)
	 * @see tutorialpoints.spring.jdbc.StudentDAO#getStudentName(java.lang.Integer)
	 */
	@Override
	public String getStudentName(int id) {
		SqlParameterSource in  = new MapSqlParameterSource().addValue("IN_ID", id);
		return jdbcCallFunc.executeFunction(String.class, in);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#listStudents()
	 */
	@Override
	public List<Student> listStudents() {
		String sql = "select * from Student";
		return jdbcTemplate.query(sql, new StudentMapper());
	}
	
	@Override
	public List<StudentMarks> listStudentMarks() {
		String sql = "select * from Student, Marks where Student.id = Marks.sid";
		return jdbcTemplate.query(sql, new StudentMarksMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		String sql = "delete from Student where id = ?";
		jdbcTemplate.update(sql, id);
		System.out.println("Deleted Record with ID = " + id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see tutorialpoints.spring.jdbc.StudentDAO#truncate()
	 */
	@Override
	public void truncate() {

		final TransactionStatus status = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			// remove all rows from student table
			String sql1 = "delete from Student";
			jdbcTemplate.update(sql1);

			// Get the latest student id to be used in Marks table
			String sql2 = "delete from Marks";
			jdbcTemplate.update(sql2);

			platformTransactionManager.commit(status);
		} catch (DataAccessException e) {
			System.err.println("Error in creating record, rolling back");
			platformTransactionManager.rollback(status);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#update(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void update(Integer id, Integer age) {
		String sql = "update Student set age = ? where id = ?";
		jdbcTemplate.update(sql, age, id);
		System.out.println("Updated Record with ID = " + id);
	}
}
