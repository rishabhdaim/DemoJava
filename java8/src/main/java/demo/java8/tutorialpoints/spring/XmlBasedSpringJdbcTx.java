/**
 * 
 */
package demo.java8.tutorialpoints.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.java8.tutorialpoints.spring.jdbc.StudentJDBCTemplate;
import demo.java8.tutorialpoints.spring.jdbc.tx.StudentMarks;

/**
 * @author Rishabh.Daim
 *
 */
public class XmlBasedSpringJdbcTx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		final StudentJDBCTemplate studentJDBCTemplate = context.getBean("studentJDBCTemplate", StudentJDBCTemplate.class);

		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11, 99, 2010);
		studentJDBCTemplate.create("Nuha", 2, 97, 2010);
		studentJDBCTemplate.create("Ayan", 15, 100, 2011);

		System.out.println("------Listing Multiple Records--------");
		List<StudentMarks> students = studentJDBCTemplate.listStudentMarks();

		for (StudentMarks record : students) {
			System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName() );
	         System.out.print(", Marks : " + record.getMarks());
	         System.out.print(", Year : " + record.getYear());
	         System.out.println(", Age : " + record.getAge());
		}
		
		// tx using AOP
		System.out.println("----------using tx AOP-------------");
		
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.createAopTx("Rishu", 11, 99, 2010);
		studentJDBCTemplate.createAopTx("Anku", 2, 97, 2010);
		studentJDBCTemplate.createAopTx("Munna", 15, 100, 2011);

		System.out.println("------Listing Multiple Records--------");
		students = studentJDBCTemplate.listStudentMarks();

		for (StudentMarks record : students) {
			System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName() );
	         System.out.print(", Marks : " + record.getMarks());
	         System.out.print(", Year : " + record.getYear());
	         System.out.println(", Age : " + record.getAge());
		}
	}
}
