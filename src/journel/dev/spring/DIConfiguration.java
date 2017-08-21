/**
 * 
 */
package journel.dev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rishabh.Daim
 *
 */
@Configuration
@ComponentScan(value="journel.dev.spring")
public class DIConfiguration {
	
	@Bean
    public MessageService getMessageService(){
        return new EmailServiceImpl();
    }
	
}
