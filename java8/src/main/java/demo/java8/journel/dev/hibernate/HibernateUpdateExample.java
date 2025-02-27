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
public class HibernateUpdateExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Prep Work
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee2 emp = (Employee2) session.get(Employee2.class, 3);
        System.out.println("Employee object loaded. " + emp);
        tx.commit();
 
        // update example
        emp.setName("Updated name");
        emp.getAddress().setCity("Bangalore");
        Transaction tx7 = session.beginTransaction();
        session.update(emp);
        emp.setName("Final updated name");
        System.out.println("13. Before committing update transaction");
        tx7.commit();
        System.out.println("14. After committing update transaction");
 
        // Close resources
        sessionFactory.close();
	}
}
