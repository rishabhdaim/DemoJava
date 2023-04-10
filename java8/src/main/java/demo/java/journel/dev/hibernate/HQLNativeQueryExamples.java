/**
 * 
 */
package demo.java.journel.dev.hibernate;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 * @author Rishabh.Daim
 *
 */
public class HQLNativeQueryExamples {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Prep work
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
         
        //Get All Employees
     // Get All Employees
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select emp_id, emp_name, cast(emp_salary as real) from MyEmployee");
        List<Object[]> rows = query.list();
        for(Object[] row : rows){
            Employee2 emp = new Employee2();
            emp.setId(Integer.parseInt(row[0].toString()));
            emp.setName(row[1].toString());
            emp.setSalary(Double.parseDouble(row[2].toString()));
            System.out.println(emp);
        }
         
        query = session.createSQLQuery("select emp_id, emp_name, emp_salary from MyEmployee")
                .addScalar("emp_id", IntegerType.INSTANCE)
                .addScalar("emp_name", StringType.INSTANCE)
                .addScalar("emp_salary", DoubleType.INSTANCE);
        rows = query.list();
        for(Object[] row : rows){
            Employee2 emp = new Employee2();
            emp.setId(Integer.parseInt(row[0].toString()));
            emp.setName(row[1].toString());
            emp.setSalary(Double.parseDouble(row[2].toString()));
            System.out.println(emp);
        }
        
        query = session.createSQLQuery("select e.emp_id, emp_name, cast(emp_salary as real), address_line1, city, zipcode from MyEmployee e, Address a where a.emp_id=e.emp_id");
        	rows = query.list();
        	for(Object[] row : rows){
        	    Employee2 emp = new Employee2();
        	    emp.setId(Integer.parseInt(row[0].toString()));
        	    emp.setName(row[1].toString());
        	    emp.setSalary(Double.parseDouble(row[2].toString()));
        	    Address address = new Address();
        	    address.setAddressLine1(row[3].toString());
        	    address.setCity(row[4].toString());
        	    address.setZipcode(row[5].toString());
        	    emp.setAddress(address);
        	    System.out.println(emp);
        	}
        	
        	
        	//Join example with addEntity and addJoin
        	query = session.createSQLQuery("select {e.*}, {a.*} from MyEmployee e inner join Address a ON e.emp_id=a.emp_id")
        	        .addEntity("e",Employee2.class)
        	        .addJoin("a","e.address");
        	rows = query.list();
        	for (Object[] row : rows) {
        	    for(Object obj : row) {
        	        System.out.print(obj + "::");
        	    }
        	    System.out.println("\n");
        	}
        	
        	//Above join returns both Employee and Address Objects in the array
        	for (Object[] row : rows) {
        	    Employee2 e = (Employee2) row[0];
        	    System.out.println("Employee Info::"+e);
        	    Address a = (Address) row[1];
        	    System.out.println("Address Info::"+a);
        	}
        	
        	query = session.createSQLQuery("select emp_id, emp_name, cast(emp_salary as real) from MyEmployee where emp_id = ?");
        	List<Object[]> empData = query.setInteger(0, 1).list();
        	for (Object[] row : empData) {
        	    Employee2 emp = new Employee2();
        	    emp.setId(Integer.parseInt(row[0].toString()));
        	    emp.setName(row[1].toString());
        	    emp.setSalary(Double.parseDouble(row[2].toString()));
        	    System.out.println(emp);
        	}
        	 
        	query = session.createSQLQuery("select emp_id, emp_name, cast(emp_salary as real) from MyEmployee where emp_id = :id");
        	empData = query.setInteger("id", 2).list();
        	for (Object[] row : empData) {
        	    Employee2 emp = new Employee2();
        	    emp.setId(Integer.parseInt(row[0].toString()));
        	    emp.setName(row[1].toString());
        	    emp.setSalary(Double.parseDouble(row[2].toString()));
        	    System.out.println(emp);
        	}
         
        //rolling back to save the test data
        tx.rollback();
         
        //closing hibernate resources
        sessionFactory.close();
	}

}
