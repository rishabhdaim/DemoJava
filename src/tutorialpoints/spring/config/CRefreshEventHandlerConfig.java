/**
 * 
 */
package tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import tutorialpoints.spring.events.CRefreshEventHandler;

/**
 * @author Rishabh.Daim
 *
 */
@Configuration
public class CRefreshEventHandlerConfig {
	
	@Bean
	@Scope("singleton")
	public CRefreshEventHandler cRefreshEventHandler() {
		return new CRefreshEventHandler();
	}
}
