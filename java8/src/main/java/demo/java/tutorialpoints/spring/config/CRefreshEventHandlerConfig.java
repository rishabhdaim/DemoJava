/**
 * 
 */
package demo.java.tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import demo.java.tutorialpoints.spring.events.CRefreshEventHandler;

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
