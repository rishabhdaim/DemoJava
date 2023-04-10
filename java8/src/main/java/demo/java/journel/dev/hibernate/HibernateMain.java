/**
 * 
 */
package demo.java.journel.dev.hibernate;

import java.util.Date;

import org.hibernate.Session;

/**
 * @author Rishabh.Daim
 *
 */
public class HibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp = new Employee();
        emp.setName("Pankaj");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());
         
        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+emp.getId());
         
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
	}

}
