/**
 * 
 */
package demo.java.journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class FbServiceInjector implements MessageServiceInjector {

	/* (non-Javadoc)
	 * @see journel.dev.spring.MessageServiceInjector#getConsumer()
	 */
	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new FbServiceImpl());
	}
}
