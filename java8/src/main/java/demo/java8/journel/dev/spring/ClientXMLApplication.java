/**
 * 
 */
package demo.java8.journel.dev.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rishabh.Daim
 *
 */
public class ClientXMLApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringXmlApplication app = context.getBean(SpringXmlApplication.class);
 
        app.processMessage("Hi Pankaj", "pankaj@abc.com");
 
        // close the context
        context.close();
	}

}
