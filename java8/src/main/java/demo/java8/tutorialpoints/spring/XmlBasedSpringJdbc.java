/**
 * 
 */
package demo.java8.tutorialpoints.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.java8.tutorialpoints.spring.annotation.Student;
import demo.java8.tutorialpoints.spring.jdbc.StudentJDBCTemplate;

/**
 * @author Rishabh.Daim
 *
 */
public class XmlBasedSpringJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		StudentJDBCTemplate studentJDBCTemplate = context.getBean("studentJDBCTemplate", StudentJDBCTemplate.class);
		
		System.out.println("removing previous records");
		// studentJDBCTemplate.truncate();

		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);

		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();

		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}

		System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);

		System.out.println("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());
		
		System.out.println("------Getting Student name with id 2------------");
		// System.out.println("Name is : " + studentJDBCTemplate.getStudentName(2));
	}
}
