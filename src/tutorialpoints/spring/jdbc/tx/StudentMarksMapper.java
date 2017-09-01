/**
 * 
 */
package tutorialpoints.spring.jdbc.tx;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Rishabh.Daim
 *
 */
public class StudentMarksMapper implements RowMapper<StudentMarks> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentMarks studentMarks = new StudentMarks();
		studentMarks.setId(rs.getInt("id"));
		studentMarks.setName(rs.getString("name"));
		studentMarks.setAge(rs.getInt("age"));
		studentMarks.setSid(rs.getInt("sid"));
		studentMarks.setMarks(rs.getInt("marks"));
		studentMarks.setYear(rs.getInt("year"));

		return studentMarks;
	}
}
