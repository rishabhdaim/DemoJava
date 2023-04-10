package demo.java.com.centurylink.prod.dsp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DbUpdator {

	void updateDspDb(String[] orderIds, Connection connection)
			throws SQLException {
		this.updateDb(orderIds, connection);
	}

	void updateOsrDb(String[] orderIds, Connection connection)
			throws SQLException {
		String query = "update order_content oc set oc.status_code = 'COMPLETED' , "
				+ "oc.completion_date = sysdate where oc.order_number = ?";
		PreparedStatement preparedStatement = connection
				.prepareStatement(query);
		executeQuery(preparedStatement, orderIds);
	}

	void updateOmniVueDb(String[] orderIds, Connection connection)
			throws SQLException {
		this.updateDb(orderIds, connection);
	}

	private void updateDb(String[] orderIds, Connection connection)
			throws SQLException {
		String query = "update task_instance ti set ti.task_instance_state = 4 , "
				+ "ti.task_instance_status = 5, ti.mod_usr = 'dspwf' where ti.master_request_id = ?";
		PreparedStatement preparedStatement = connection
				.prepareStatement(query);
		executeQuery(preparedStatement, orderIds);
	}

	private void executeQuery(PreparedStatement preparedStatement,
			String[] orderIds) throws SQLException {
		for (String string : orderIds) {
			preparedStatement.setString(1, string);
			preparedStatement.executeUpdate();
		}
	}
}
