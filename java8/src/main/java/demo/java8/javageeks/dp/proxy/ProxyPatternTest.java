/**
 * 
 */
package demo.java8.javageeks.dp.proxy;

/**
 * @author rishabh.daim
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