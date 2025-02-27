/**
 * 
 */
package demo.java8.tutorialpoints.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author Rishabh.Daim
 *
 */
public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextStoppedEvent event) {
		System.out.println("ContextStoppedEvent Received");
	}
}
