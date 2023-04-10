/**
 * 
 */
package demo.java.journel.dev.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Rishabh.Daim
 *
 */
public class PersonDAOImpl implements PersonDAO {
	
	private SessionFactory sessionFactory;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/* (non-Javadoc)
	 * @see journel.dev.hibernate.PersonDAO#save(journel.dev.hibernate.Person)
	 */
	@Override
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
	}

	/* (non-Javadoc)
	 * @see journel.dev.hibernate.PersonDAO#list()
	 */
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
        @SuppressWarnings("unchecked")
		List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
	}

}
