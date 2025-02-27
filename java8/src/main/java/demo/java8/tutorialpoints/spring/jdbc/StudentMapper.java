/**
 * 
 */
package demo.java8.tutorialpoints.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import demo.java8.tutorialpoints.spring.annotation.Student;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Rishabh.Daim
 *
 */
public class StudentMapper implements RowMapper<Student> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Student student = new Student();
		student.setAge(rs.getInt("age"));
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		return student;
	}
}
