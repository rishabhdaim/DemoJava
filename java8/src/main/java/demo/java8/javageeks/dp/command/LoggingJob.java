/**
 * 
 */
package demo.java8.javageeks.dp.command;

/**
 * @author Rishabh.Daim
 *
 */
public class LoggingJob implements Job {

	private Logging logging;

	public LoggingJob() {

	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setLogging(Logging logging) {
		this.logging = logging;
	}

	@Override
	public void run() {
		System.out.println("Job ID: " + Thread.currentThread().getId()
				+ " executing logging jobs.");
		if (logging != null) {
			logging.log();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
