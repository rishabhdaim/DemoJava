/**
 * 
 */
package demo.java8.journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class SMSServiceInjector implements MessageServiceInjector {

	/* (non-Javadoc)
	 * @see journel.dev.spring.MessageServiceInjector#getConsumer()
	 */
	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}
}
