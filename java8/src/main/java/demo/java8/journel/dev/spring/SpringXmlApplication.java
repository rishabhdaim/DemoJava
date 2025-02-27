/**
 * 
 */
package demo.java8.journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class SpringXmlApplication {

	private MessageService service;
	
	//setter-based dependency injection
    public void setService(MessageService svc){
        this.service=svc;
    }
    
    public void processMessage(String msg, String rec) {
        // some magic like validation, logging etc
        this.service.sendMessage(msg, rec);
    }
}
