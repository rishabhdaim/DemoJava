/**
 * 
 */
package demo.java8.tutorialpoints.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Rishabh.Daim
 *
 */
public class CRefreshEventHandler implements ApplicationListener<ContextRefreshedEvent> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("ContextRefreshedEvent Received");
	}
}
