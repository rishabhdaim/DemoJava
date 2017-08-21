/**
 * 
 */
package journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class SMSServiceImpl implements MessageService {

	/* (non-Javadoc)
	 * @see journel.dev.spring.MessageService#sendMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendMessage(String msg, String rec) {
		System.out.println("SMS sent to "+rec+ " with Message="+msg);
	}

}
