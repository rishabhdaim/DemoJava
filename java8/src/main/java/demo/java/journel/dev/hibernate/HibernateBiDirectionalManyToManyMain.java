/**
 * 
 */
package demo.java.journel.dev.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Rishabh.Daim
 *
 */
public class HibernateBiDirectionalManyToManyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Item iphone = new Item();
        iphone.setPrice(100); iphone.setDescription("iPhone");
         
        Item ipod = new Item();
        ipod.setPrice(50); ipod.setDescription("iPod");
         
        Carts cart = new Carts();
        cart.setTotal(150);
         
        Carts cart1 = new Carts();
        cart1.setTotal(100);
         
        Set<Carts> cartSet = new HashSet<>();
        cartSet.add(cart);cartSet.add(cart1);
         
        Set<Carts> cartSet1 = new HashSet<>();
        cartSet1.add(cart);
         
        iphone.setCarts(cartSet1);
        ipod.setCarts(cartSet);
         
        SessionFactory sessionFactory = null;
        try{
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(iphone);
        session.save(ipod);
        tx.commit();
        sessionFactory.close();
         
        System.out.println("Cart ID="+cart.getId());
        System.out.println("Cart1 ID="+cart1.getId());
        System.out.println("Item1 ID="+iphone.getId());
        System.out.println("Item2 ID="+ipod.getId());
         
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
        }	
	}

}
