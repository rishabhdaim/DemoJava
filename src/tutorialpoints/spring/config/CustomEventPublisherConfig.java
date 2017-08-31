/**
 * 
 */
package tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tutorialpoints.spring.events.CustomEventPublisher;

/**
 * @author Rishabh.Daim
 *
 */
@Configuration
public class CustomEventPublisherConfig {
	
	@Bean
	public CustomEventPublisher customEventPublisher() {
		return new CustomEventPublisher();
	}
}
