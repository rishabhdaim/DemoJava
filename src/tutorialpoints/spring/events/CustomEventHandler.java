/**
 * 
 */
package tutorialpoints.spring.events;

import org.springframework.context.ApplicationListener;

/**
 * @author Rishabh.Daim
 *
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(event);
	}

}
