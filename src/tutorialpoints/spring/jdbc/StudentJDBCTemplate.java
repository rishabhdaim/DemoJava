/**
 * 
 */
package tutorialpoints.spring.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import tutorialpoints.spring.annotation.Student;

/**
 * @author Rishabh.Daim
 *
 */
public class StudentJDBCTemplate implements StudentDAO {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcCall jdbcCall;

	public StudentJDBCTemplate(final DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("GETSTUDENT");
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
		List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
		return students;
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
