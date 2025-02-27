/**
 * 
 */
package demo.java8.tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.java8.tutorialpoints.spring.xml.HelloWorld;

/**
 * @author Rishabh.Daim
 *
 */
// configuration means source of bean definition
@Configuration
public class HelloWorldConfig {
	
	// bean means a spring bean, method name is bean ID
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
