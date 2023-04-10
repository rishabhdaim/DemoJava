/**
 * 
 */
package demo.java.journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class MyDIApplication implements Consumer {

	private MessageService service;
	
	public MyDIApplication(MessageService svc) {
		this.service = svc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see journel.dev.spring.Consumer#processMessages(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void processMessages(String msg, String rec) {
		// do some msg validation, manipulation logic etc
		this.service.sendMessage(msg, rec);
	}
}
