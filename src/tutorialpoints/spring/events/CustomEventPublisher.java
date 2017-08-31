/**
 * 
 */
package tutorialpoints.spring.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author Rishabh.Daim
 *
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher publisher;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationEventPublisherAware#setApplicationEventPublisher(org.springframework.context.ApplicationEventPublisher)
	 */
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
	
	public void publish() {
		CustomEvent ce = new CustomEvent(this);
		this.publisher.publishEvent(ce);
	}

}
