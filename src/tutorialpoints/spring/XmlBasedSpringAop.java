/**
 * 
 */
package tutorialpoints.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorialpoints.spring.annotation.Profile;
import tutorialpoints.spring.annotation.Student;

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
	}

}
