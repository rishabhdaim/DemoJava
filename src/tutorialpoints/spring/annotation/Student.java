/**
 * 
 */
package tutorialpoints.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author Rishabh.Daim
 *
 */
public class Student {

	private Integer age;
	private String name;
	private Integer id;

	// similar to required but now, age is not mandatory
	@Autowired(required = false)
	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		//System.out.println("Age : " + age);
		return age;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		//System.out.println("Name : " + name);
		return name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		//System.out.println("Id : " + id);
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
}
