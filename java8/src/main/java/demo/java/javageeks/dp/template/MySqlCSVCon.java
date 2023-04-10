/**
 * 
 */
package demo.java.javageeks.dp.template;

/**
 * @author Rishabh.Daim
 *
 */
public class MySqlCSVCon implements ConnectionTemplate {

	/* (non-Javadoc)
	 * @see javageeks.dp.template.ConnectionTemplate#setData()
	 */
	@Override
	public void setData() {
		System.out.println("Setting up data from csv file....");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.template.ConnectionTemplate#setCredentials()
	 */
	@Override
	public void setCredentials() {
		System.out.println("Setting credentials for MySQL DB...");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.template.ConnectionTemplate#setDBDriver()
	 */
	@Override
	public void setDBDriver() {
		System.out.println("Setting MySQL DB drivers...");
	}

	@Override
	public boolean disableLogging() {
		return true;
	}

}
