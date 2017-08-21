/**
 * 
 */
package journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public interface Consumer {
	
	void processMessages(String msg, String rec);
}
