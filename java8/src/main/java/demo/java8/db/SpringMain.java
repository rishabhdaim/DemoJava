/**
 * 
 */
package demo.java8.db;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rishabh.Daim
 *
 */
public class SpringMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
         
        //Get the EmployeeDAO Bean
        EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
         
        //Run some tests for JDBC CRUD operations
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);
        System.out.println(rand);
        emp.setId(rand);
        emp.setName("Pankaj");
        emp.setRole("Developer");
        emp.setCity("Noida");
        emp.setCountry("India");
         
        //Create
        employeeDAO.save(emp);
         
        //Read
        Employee emp1 = employeeDAO.getById(rand);
        System.out.println("Employee Retrieved::"+emp1);
         
        //Update
        emp.setRole("CEO");
        employeeDAO.update(emp);
         
        //Get All
        List<Employee> empList = employeeDAO.getAll();
        System.out.println(empList);
         
        //Delete
        employeeDAO.deleteById(rand);
         
        //Close Spring Context
        ctx.close();
         
        System.out.println("DONE");
	}

}
