/**
 * 
 */
package demo.java8.tutorialpoints.spring.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author Rishabh.Daim
 *
 */
public class CustomEvent extends ApplicationEvent {

	public CustomEvent(Object source) {
		super(source);
	}
	
	@Override
	public String toString() {
		return "My Custom Event";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
