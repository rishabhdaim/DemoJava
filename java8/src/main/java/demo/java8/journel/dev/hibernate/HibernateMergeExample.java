/**
 * 
 */
package demo.java8.journel.dev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Rishabh.Daim
 *
 */
public class HibernateMergeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Prep Work
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee2 emp = (Employee2) session.get(Employee2.class, 4);
        System.out.println("Employee object loaded. " + emp);
        tx.commit();
 
         //merge example - data already present in tables
         emp.setSalary(35000);
         Transaction tx8 = session.beginTransaction();
         Employee2 emp4 = (Employee2) session.merge(emp);
         System.out.println(emp4 == emp); // returns false
         emp.setName("Test");
         emp4.setName("Kumar");
         System.out.println("15. Before committing merge transaction");
         tx8.commit();
         System.out.println("16. After committing merge transaction");
 
        // Close resources
        sessionFactory.close();
	}

}
