/**
 * 
 */
package tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import tutorialpoints.spring.events.CStopEventHandler;

/**
 * @author Rishabh.Daim
 *
 */
@Configuration
public class CStopEventHandlerConfig {
	
	@Bean
	@Scope("singleton")
	public CStopEventHandler cStopEventHandler() {
		return new CStopEventHandler();
	}
}
