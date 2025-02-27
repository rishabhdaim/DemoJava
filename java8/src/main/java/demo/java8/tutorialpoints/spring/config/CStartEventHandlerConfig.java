/**
 * 
 */
package demo.java8.tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import demo.java8.tutorialpoints.spring.events.CStartEventHandler;

/**
 * @author Rishabh.Daim
 *
 */
@Configuration
public class CStartEventHandlerConfig {
	
	@Bean
	@Scope("singleton")
	public CStartEventHandler cStartEventHandler() {
		return new CStartEventHandler();
	}
}
