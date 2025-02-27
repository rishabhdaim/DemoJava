/**
 * 
 */
package demo.java8.journel.dev.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Rishabh.Daim
 *
 */
public class HQLExamples {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Prep work
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
         
        //Get All Employees
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Employee2");
        List<Employee2> empList = query.list();
        for(Employee2 emp : empList) {
            System.out.println("List of Employees::"+emp.getId()+","+emp.getAddress().getCity());
        }
         
        //Get Employee with id
        query = session.createQuery("from Employee2 where id= :id");
        query.setLong("id", 3);
        Employee2 emp = (Employee2) query.uniqueResult();
        System.out.println("Employee Name="+emp.getName()+", City="+emp.getAddress().getCity());
         
        //pagination example
        query = session.createQuery("from Employee2");
        query.setFirstResult(0); //starts with 0
        query.setFetchSize(2);
        empList = query.list();
        for(Employee2 emp4 : empList) {
            System.out.println("Paginated Employees::"+emp4.getId()+","+emp4.getAddress().getCity());
        }
         
        //Update Employee
        query = session.createQuery("update Employee2 set name= :name where id= :id");
        query.setParameter("name", "Pankaj Kumar");
        query.setLong("id", 1);
        int result = query.executeUpdate();
        System.out.println("Employee Update Status="+result);
 
        //Delete Employee, we need to take care of foreign key constraints too
        query = session.createQuery("delete from Address where id= :id");
        query.setLong("id", 4);
        result = query.executeUpdate();
        System.out.println("Address Delete Status="+result);
         
        query = session.createQuery("delete from Employee2 where id= :id");
        query.setLong("id", 4);
        result = query.executeUpdate();
        System.out.println("Employee Delete Status="+result);
         
        //Aggregate function examples
        query = session.createQuery("select sum(salary) from Employee2");
        double sumSalary = (Double) query.uniqueResult();
        System.out.println("Sum of all Salaries= "+sumSalary);
         
        //join examples
        query = session.createQuery("select e.name, a.city from Employee2 e INNER JOIN e.address a");
        List<Object[]> list = query.list();
        for(Object[] arr : list){
            System.out.println(Arrays.toString(arr));
        }
         
        //group by and like example
        query = session.createQuery("select e.name, sum(e.salary), count(e) from Employee2 e where e.name like '%i%' group by e.name");
        List<Object[]> groupList = query.list();
        for(Object[] arr : groupList){
            System.out.println(Arrays.toString(arr));
        }
         
        //order by example
        query = session.createQuery("from Employee2 e order by e.id desc");
        empList = query.list();
        for(Employee2 emp3 : empList) {
            System.out.println("ID Desc Order Employee::"+emp3.getId()+","+emp3.getAddress().getCity());
        }
         
        //rolling back to save the test data
        tx.rollback();
         
        //closing hibernate resources
        sessionFactory.close();
	}

}
