/**
 * 
 */
package demo.java.javageeks.dp.iterator;

/**
 * @author rishabh.daim
 * 
 */
public interface ChannelCollection {
	
	void addChannel(Channel c);

	void removeChannel(Channel c);

	ChannelIterator iterator(ChannelTypeEnum type);
}
