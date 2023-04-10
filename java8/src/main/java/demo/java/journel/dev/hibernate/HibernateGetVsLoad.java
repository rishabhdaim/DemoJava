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
public class HibernateGetVsLoad {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Prep Work
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
         
        //Get Example
        Employee2 emp = (Employee2) session.get(Employee2.class, 2);
        System.out.println("Employee2 get called");
        System.out.println("Employee2 ID= "+emp.getId());
        System.out.println("Employee2 Get Details:: "+emp+"\n");
         
        //load Example
        Employee2 emp1 = (Employee2) session.load(Employee2.class, 1);
        System.out.println("Employee2 load called");
        System.out.println("Employee2 ID= "+emp1.getId());
        System.out.println("Employee2 load Details:: "+emp1+"\n");
         
        //Close resources
        tx.commit();
        
        sessionFactory.close();
	}

}
