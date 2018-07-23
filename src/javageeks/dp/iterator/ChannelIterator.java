/**
 * 
 */
package javageeks.dp.iterator;

/**
 * @author rishabh.daim
 * 
 */
public interface ChannelIterator {
	
	boolean hasNext();

	Channel next();

	Channel remove();
}
