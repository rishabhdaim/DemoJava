package db;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean isEmployeeExists(String emp_id) throws DataAccessException {
		logger.debug("Checking Employee in EMP table using Spring Jdbc Template");
		int number = this.jdbcTemplate.queryForInt(
				"select count(*) from EMP where emp_id=?", emp_id);
		if (number > 0) {
			return true;
		}

		return false;
	}
	public static void main(String[] args) {
		System.out.println("new");
	}
}