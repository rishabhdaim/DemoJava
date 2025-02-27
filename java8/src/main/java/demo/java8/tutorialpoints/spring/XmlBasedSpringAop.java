/**
 * 
 */
package demo.java8.tutorialpoints.spring;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.java8.tutorialpoints.spring.annotation.Profile;
import demo.java8.tutorialpoints.spring.annotation.Student;
import demo.java8.tutorialpoints.spring.annotation.aspectj.Logging;

/**
 * @author Rishabh.Daim
 *
 */
public class XmlBasedSpringAop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = context.getBean("student", Student.class);
		student.getName();
		student.getAge();
		try {
			student.printThrowException();
		} catch (Exception e) {
			
		}
		
		System.out.println("---------------------------------------");
		
		Profile profile = context.getBean("profile", Profile.class);
		profile.printName();
		profile.printAge();
		
		System.out.println("---------------------------------------");
		
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(profile);
		proxyFactory.addAspect(Logging.class);
		Profile proxyProfile = proxyFactory.getProxy();
		proxyProfile.printName();
		proxyProfile.printAge();
	}
}
