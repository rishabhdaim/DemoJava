/**
 * 
 */
package journel.dev.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Rishabh.Daim
 *
 */
public class HibernateAnnotationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee1 emp = new Employee1();
		emp.setName("rishu");
		emp.setRole("developer");
		emp.setInsertTime(new Date());
		
		// get session
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		
		// start transaction
		session.beginTransaction();
		
		// save model
		session.save(emp);
		
		// commit transaction
		session.getTransaction().commit();
		
		System.out.println("Employee ID = "+ emp.getId());
        
        //terminate session factory, otherwise program won't end
        sessionFactory.close();
	}

}
