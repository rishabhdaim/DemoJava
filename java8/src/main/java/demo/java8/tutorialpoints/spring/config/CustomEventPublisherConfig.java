/**
 * 
 */
package demo.java8.tutorialpoints.spring.config;

import demo.java8.tutorialpoints.spring.events.CustomEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
