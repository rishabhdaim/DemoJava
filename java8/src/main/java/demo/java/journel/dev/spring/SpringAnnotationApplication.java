/**
 * 
 */
package demo.java.journel.dev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Rishabh.Daim
 *
 */
@Component
public class SpringAnnotationApplication {
	
	private MessageService messageService;

	/**
	 * @param messageService
	 */
	@Autowired
	public SpringAnnotationApplication(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void processMessage(String msg, String rec){
        //some magic like validation, logging etc
        this.messageService.sendMessage(msg, rec);
    }

}
