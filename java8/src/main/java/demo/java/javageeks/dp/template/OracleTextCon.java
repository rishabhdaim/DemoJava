/**
 * 
 */
package demo.java.javageeks.dp.template;

/**
 * @author Rishabh.Daim
 *
 */
public class OracleTextCon implements ConnectionTemplate {

	/* (non-Javadoc)
	 * @see javageeks.dp.template.ConnectionTemplate#setData()
	 */
	@Override
	public void setData() {
		System.out.println("Setting up data from text file....");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.template.ConnectionTemplate#setCredentials()
	 */
	@Override
	public void setCredentials() {
		System.out.println("Setting credentials for Oracle DB...");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.template.ConnectionTemplate#setDBDriver()
	 */
	@Override
	public void setDBDriver() {
		System.out.println("Setting Oracle DB drivers...");
	}

	@Override
	public boolean disableLogging() {
		return false;
	}

}
