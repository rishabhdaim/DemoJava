/**
 * 
 */
package tutorialpoints.spring.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 
 * @author Rishabh.Daim
 *
 */
public class InitHelloWorld implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof HelloWorld) {
			System.out.println("Before Initialization " + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof HelloWorld) {
			System.out.println("After Initialization " + beanName);
		}
		return bean;
	}
	
}
