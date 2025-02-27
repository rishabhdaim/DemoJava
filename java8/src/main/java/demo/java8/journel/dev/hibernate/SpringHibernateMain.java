/**
 * 
 */
package demo.java8.journel.dev.hibernate;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rishabh.Daim
 *
 */
public class SpringHibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        PersonDAO personDAO = context.getBean(PersonDAO.class);
         
        Person person = new Person();
        person.setName("Pankaj"); person.setCountry("India");
         
        personDAO.save(person);
         
        System.out.println("Person::"+person);
         
        List<Person> list = personDAO.list();
         
        for(Person p : list){
            System.out.println("Person List::"+p);
        }
        //close resources
        context.close();    
	}

}
