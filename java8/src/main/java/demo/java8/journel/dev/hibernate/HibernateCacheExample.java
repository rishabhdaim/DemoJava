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
public class HibernateCacheExample {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// Get employee with id=1
		Employee2 emp = (Employee2) session.get(Employee2.class, 1);
		printData(emp, 1);

		// waiting for sometime to change the data in backend
		Thread.sleep(10000);

		// Fetch same data again, check logs that no query fired
		Employee2 emp1 = (Employee2) session.get(Employee2.class, new Integer(1));
		printData(emp1, 2);

		// Create new session
		Session newSession = sessionFactory.openSession();
		// Get employee with id=1, notice the logs for query
		Employee2 emp2 = (Employee2) newSession.get(Employee2.class, new Integer(1));
		printData(emp2, 3);

		// START: evict example to remove specific object from hibernate first
		// level cache
		// Get employee with id=2, first time hence query in logs
		Employee2 emp3 = (Employee2) session.get(Employee2.class, new Integer(2));
		printData(emp3, 4);

		// evict the employee object with id=1
		session.evict(emp);
		System.out.println("Session Contains Employee with id=1?" + session.contains(emp));

		// since object is removed from first level cache, you will see query in
		// logs
		Employee2 emp4 = (Employee2) session.get(Employee2.class, new Integer(1));
		printData(emp4, 5);

		// this object is still present, so you won't see query in logs
		Employee2 emp5 = (Employee2) session.get(Employee2.class, new Integer(2));
		printData(emp5, 6);
		// END: evict example

		// START: clear example to remove everything from first level cache
		session.clear();
		Employee2 emp6 = (Employee2) session.get(Employee2.class, new Integer(1));
		printData(emp6, 7);
		Employee2 emp7 = (Employee2) session.get(Employee2.class, new Integer(2));
		printData(emp7, 8);

		System.out.println("Session Contains Employee with id=2? "
				+ session.contains(emp7));

		tx.commit();
		sessionFactory.close();
	}

	private static void printData(Employee2 emp, int count) {
		System.out.println(emp + " : " + count + ":: Name=" + emp.getName() + ", Zipcode=" + emp.getAddress().getZipcode());
	}

}
