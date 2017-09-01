/**
 * 
 */
package tutorialpoints.spring.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import tutorialpoints.spring.annotation.Student;
import tutorialpoints.spring.jdbc.tx.StudentMarks;
import tutorialpoints.spring.jdbc.tx.StudentMarksMapper;

/**
 * @author Rishabh.Daim
 *
 */
public class StudentJDBCTemplate implements StudentDAO {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcCall jdbcCall;
	private final PlatformTransactionManager platformTransactionManager;

	public StudentJDBCTemplate(final DataSource dataSource, final PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("GETSTUDENT");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#create(java.lang.String,
	 * java.lang.Integer)
	 */
	@Override
	public void create(String name, Integer age) {
		final String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplate.update(SQL, name, age);
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
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplate.update(SQL1, name, age);

			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			int sid = jdbcTemplate.queryForObject(SQL2, int.class);

			String SQL3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
			jdbcTemplate.update(SQL3, sid, marks, year);

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
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplate.update(SQL1, name, age);

			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			int sid = jdbcTemplate.queryForObject(SQL2, int.class);

			String SQL3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
			jdbcTemplate.update(SQL3, sid, marks, year);

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
		/*String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new StudentMapper());*/
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("IN_ID", id);
		Map<String, Object> result = jdbcCall.execute(in);
		
		Student student = new Student();
		student.setId(id);
		student.setName((String) result.get("OUT_NAME"));
		student.setAge(((BigDecimal)result.get("OUT_AGE")).intValueExact());
		
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#listStudents()
	 */
	@Override
	public List<Student> listStudents() {
		String SQL = "select * from Student";
		return jdbcTemplate.query(SQL, new StudentMapper());
	}
	
	@Override
	public List<StudentMarks> listStudentMarks() {
		String SQL = "select * from Student, Marks where Student.id = Marks.sid";
		return jdbcTemplate.query(SQL, new StudentMarksMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tutorialpoints.spring.jdbc.StudentDAO#update(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplate.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
	}
}
