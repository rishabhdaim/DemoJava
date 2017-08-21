/**
 * 
 */
package journel.dev.hibernate;

import java.util.List;

/**
 * @author Rishabh.Daim
 *
 */
public interface PersonDAO {
	
	public void save(Person p);
    
    public List<Person> list();
    
}
