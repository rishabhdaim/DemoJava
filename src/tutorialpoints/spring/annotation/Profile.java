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

	public void printAge() {
		System.out.println("Age : " + student.getAge());
	}

	public void printName() {
		System.out.println("Name : " + student.getName());
	}
}
