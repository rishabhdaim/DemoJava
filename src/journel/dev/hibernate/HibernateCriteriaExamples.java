/**
 * 
 */
package journel.dev.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 * @author Rishabh.Daim
 *
 */
public class HibernateCriteriaExamples {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Prep work
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
 
        //Get All Employees
        Criteria criteria = session.createCriteria(Employee2.class);
        List<Employee2> empList = criteria.list();
        for(Employee2 emp : empList){
            System.out.println("ID="+emp.getId()+", Zipcode="+emp.getAddress().getZipcode());
        }
         
        // Get with ID, creating new Criteria to remove all the settings
        criteria = session.createCriteria(Employee2.class)
                    .add(Restrictions.eq("id", 3));
        Employee2 emp = (Employee2) criteria.uniqueResult();
        System.out.println("Name=" + emp.getName() + ", City="
                + emp.getAddress().getCity());
 
        //Pagination Example
        empList = session.createCriteria(Employee2.class)
                    .addOrder(Order.desc("id"))
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .list();
        for(Employee2 emp4 : empList){
            System.out.println("Paginated Employees::"+emp4.getId()+","+emp4.getAddress().getCity());
        }
 
        //Like example
        empList = session.createCriteria(Employee2.class)
                .add(Restrictions.like("name", "%i%"))
                .list();
        for(Employee2 emp4 : empList){
            System.out.println("Employees having 'i' in name::"+emp4.getName()+","+emp4.getAddress().getCity());
        }
         
        //Projections example
        long count = (Long) session.createCriteria(Employee2.class)
                .setProjection(Projections.rowCount())
                .add(Restrictions.like("name", "%i%"))
                .uniqueResult();
        System.out.println("Number of employees with 'i' in name="+count);
 
        //using Projections for sum, min, max aggregation functions
        double sumSalary = (Double) session.createCriteria(Employee2.class)
            .setProjection(Projections.sum("salary"))
            .uniqueResult();
        System.out.println("Sum of Salaries="+sumSalary);
         
        //Join example for selecting few columns
        criteria = session.createCriteria(Employee2.class, "employee");
        criteria.setFetchMode("employee.address", FetchMode.JOIN);
        criteria.createAlias("employee.address", "address", JoinType.INNER_JOIN); // inner join by default
 
        ProjectionList columns = Projections.projectionList()
                        .add(Projections.property("name"))
                        .add(Projections.property("address.city"));
        criteria.setProjection(columns);
 
        List<Object[]> list = criteria.list();
        for(Object[] arr : list){
            System.out.println(Arrays.toString(arr));
        }
         
         
        // Rollback transaction to avoid messing test data
        tx.commit();
        // closing hibernate resources
        sessionFactory.close();
	}

}
