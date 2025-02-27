/**
 * 
 */
package demo.java8.tutorialpoints.spring.config;

import demo.java8.tutorialpoints.spring.events.CustomEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Rishabh.Daim
 *
 */
@Configuration
public class CustomEventHandlerConfig {
	
	@Bean
	@Scope("singleton")
	public CustomEventHandler customEventHandler() {
		return new CustomEventHandler();
	}
}
