/**
 * 
 */
package javageeks.dp.proxy;

/**
 * @author aa49442
 * 
 */
public class ProxyPatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CommandExecutor commandExecutor = new CommandExecutorProxy("rishu",
				"asdf");
		try {
			commandExecutor.runCommand("java");
			Thread.sleep(100);
			commandExecutor.runCommand("rm -rf abc.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}