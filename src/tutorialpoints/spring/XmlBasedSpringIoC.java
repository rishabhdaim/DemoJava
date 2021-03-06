/**
 * 
 */
package tutorialpoints.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorialpoints.spring.annotation.Profile;
import tutorialpoints.spring.annotation.Student;
import tutorialpoints.spring.xml.HelloIndia;
import tutorialpoints.spring.xml.HelloWorld;
import tutorialpoints.spring.xml.JavaCollection;
import tutorialpoints.spring.xml.TextEditor;

/**
 * @author Rishabh.Daim
 *
 */
public class XmlBasedSpringIoC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		
		helloWorld.getMessage();
		helloWorld.setMessage("New Message"); // to check singleton value
		helloWorld.getMessage();
		
		HelloWorld helloWorld1 = context.getBean("helloWorld", HelloWorld.class);
		helloWorld1.getMessage();
		System.out.println("Same instance : " + (helloWorld == helloWorld1));
		System.out.println("-----------------------");
		
		// prototype scope
		helloWorld = context.getBean("helloWorld2", HelloWorld.class);
		
		helloWorld.getMessage();
		helloWorld.setMessage("New Message"); // to check singleton value
		helloWorld.getMessage();
		
		helloWorld1 = context.getBean("helloWorld2", HelloWorld.class);
		helloWorld1.getMessage();
		System.out.println("Same instance : " + (helloWorld == helloWorld1));
		System.out.println("-----------------------");
		
		// spring bean inheritence
		HelloIndia helloIndia = context.getBean("helloIndia", HelloIndia.class);
		helloIndia.getMessage();
		helloIndia.getMessage2();
		helloIndia.getMessage3();
		System.out.println("-----------------------");
		
		// spring bean inheritence
		helloIndia = context.getBean("helloIndia2", HelloIndia.class);
		helloIndia.getMessage();
		helloIndia.getMessage2();
		helloIndia.getMessage3();
		System.out.println("-----------------------");
		
		// text editor & spell checker
		TextEditor editor = context.getBean("textEditor", TextEditor.class);
		editor.spellCheck();
		System.out.println("-----------------------");
		
		// java collections
		JavaCollection javaCollection = context.getBean("javaCollection", JavaCollection.class);
		javaCollection.getAddressList();
		javaCollection.getAddressSet();
		javaCollection.getAddressMap();
		javaCollection.getAddressProp();
		System.out.println("-----------------------");
		
		Student student = context.getBean("student", Student.class);
		System.out.println("Name : " + student.getName());
	    System.out.println("Age : " + student.getAge());
	    System.out.println("-----------------------");
	    
	    tutorialpoints.spring.annotation.TextEditor textEditor = context.getBean("textEditor1", tutorialpoints.spring.annotation.TextEditor.class);
	    textEditor.spellCheck();
	    System.out.println("-----------------------");
	    
	    Profile profile = context.getBean("profile", Profile.class);
	    profile.printName();
	    profile.printAge();
	    System.out.println("-----------------------");
		
		if (context instanceof AbstractApplicationContext) {
			((AbstractApplicationContext)context).registerShutdownHook();
		}
	}
}
