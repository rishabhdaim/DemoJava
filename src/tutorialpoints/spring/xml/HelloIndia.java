/**
 * 
 */
package tutorialpoints.spring.xml;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 
 * @author Rishabh.Daim
 *
 */
public class HelloIndia {

	private String message;
	private String message2;
	private String message3;
	
	// setter based sprint dependency injection
	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}
	
	/**
	 * @return the message2
	 */
	public final void getMessage2() {
		System.out.println("Your Message : " + message2);
	}

	/**
	 * @param message2 the message2 to set
	 */
	public final void setMessage2(String message2) {
		this.message2 = message2;
	}

	/**
	 * @return the message3
	 */
	public final void getMessage3() {
		System.out.println("Your Message : " + message3);
	}

	/**
	 * @param message3 the message3 to set
	 */
	public final void setMessage3(String message3) {
		this.message3 = message3;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Bean initialization helloindia");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Bean destruction helloindia");
	}
}
