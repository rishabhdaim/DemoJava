/**
 * 
 */
package demo.java.journel.dev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Rishabh.Daim
 *
 */
public class HibernateSaveExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Prep Work
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
         
        //save example - without transaction
        Session session = sessionFactory.openSession();
        Employee2 emp = getTestEmployee();
        int id = (Integer) session.save(emp);
        System.out.println("1. Employee2 save called without transaction, id="+id);
        session.flush(); //address will not get saved without this
        System.out.println("*****");
         
        //save example - with transaction
        Transaction tx1 = session.beginTransaction();
        Session session1 = sessionFactory.openSession();
        Employee2 emp1 = getTestEmployee();
        int id1 = (Integer) session1.save(emp1);
        System.out.println("2. Employee2 save called with transaction, id="+id1);
        System.out.println("3. Before committing save transaction");
        tx1.commit();
        System.out.println("4. After committing save transaction");
        System.out.println("*****");
         
        //save example - existing row in table
        Session session6 = sessionFactory.openSession();
        Transaction tx6 = session6.beginTransaction();
        Employee2 emp6 =  (Employee2) session6.get(Employee2.class, new Integer(3));
         
        //update some data
        System.out.println("Employee2 Details="+emp6);
        emp6.setName("New Name");
        emp6.getAddress().setCity("New City");
         
        int id6 = (Integer) session6.save(emp6);
        emp6.setName("New Name1"); // will get updated in database
        System.out.println("5. Employee2 save called with transaction, id="+id6);
        System.out.println("6. Before committing save transaction");
        tx6.commit();
        System.out.println("7. After committing save transaction");
        System.out.println("*****");
         
        // Close resources
        sessionFactory.close();
	}
	
	public static Employee2 getTestEmployee() {
        Employee2 emp = new Employee2();
        Address add = new Address();
        emp.setName("Test Emp");
        emp.setSalary(1000);
        add.setAddressLine1("Test address1");
        add.setCity("Test City");
        add.setZipcode("12121");
        emp.setAddress(add);
        add.setEmployee(emp);
        return emp;
    }
}
