/**
 * 
 */
package tutorialpoints.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Rishabh.Daim
 *
 */
public class Profile {
	
	// property based auto-wiring, no need for setter now
	@Autowired
	@Qualifier("student1")
	private Student student;

	public Profile() {
		System.out.println("Inside Profile constructor.");
	}

	public Integer printAge() {
		Integer age = student.getAge();
		System.out.println("Age : " + age);
		return age;
	}

	public String printName() {
		String name = student.getName();
		System.out.println("Name : " + name);
		return name;
	}
}
