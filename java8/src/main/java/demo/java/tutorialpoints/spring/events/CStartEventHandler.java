/**
 * 
 */
package demo.java.tutorialpoints.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author Rishabh.Daim
 *
 */
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("ContextStartedEvent Received");
	}
}
