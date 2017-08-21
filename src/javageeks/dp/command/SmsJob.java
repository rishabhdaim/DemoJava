/**
 * 
 */
package javageeks.dp.command;

/**
 * @author Rishabh.Daim
 *
 */
public class SmsJob implements Job {

	private Sms sms;

	public SmsJob() {

	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setSms(Sms sms) {
		this.sms = sms;
	}

	@Override
	public void run() {
		System.out.println("Job ID: " + Thread.currentThread().getId()
				+ " executing sms jobs.");
		if (sms != null) {
			sms.sendSms();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
