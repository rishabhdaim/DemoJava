/**
 * 
 */
package tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import tutorialpoints.spring.events.CustomEventHandler;

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
