/**
 * 
 */
package demo.java.journel.dev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Rishabh.Daim
 *
 */
public class ClientApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        SpringAnnotationApplication app = context.getBean(SpringAnnotationApplication.class);
         
        app.processMessage("Hi Pankaj", "pankaj@abc.com");
         
        //close the context
        context.close();
	}

}
