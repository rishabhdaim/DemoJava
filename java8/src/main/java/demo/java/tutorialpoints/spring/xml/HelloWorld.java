/**
 * 
 */
package demo.java.tutorialpoints.spring.xml;

/**
 * 
 * @author Rishabh.Daim
 *
 */
public class HelloWorld {

	private String message;
	private String message2;
	
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
	public String getMessage2() {
		return message2;
	}

	/**
	 * @param message2 the message2 to set
	 */
	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public void init() {
		System.out.println("Bean initialization helloworld");
	}
	
	public void destroy() {
		System.out.println("Bean destruction helloworld");
	}
}
