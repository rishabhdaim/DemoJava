/**
 * 
 */
package javageeks.dp.template;

/**
 * @author Rishabh.Daim
 *
 */
public class TestTemplatePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("For MYSQL....");
		ConnectionTemplate template = new MySqlCSVCon();
		template.run();
		System.out.println();
		System.out.println("For Oracle...");
		template = new OracleTextCon();
		template.run();
	}

}
