/**
 * 
 */
package javageeks.dp.iterator;

/**
 * @author aa49442
 * 
 */
public interface ChannelCollection {
	
	void addChannel(Channel c);

	void removeChannel(Channel c);

	ChannelIterator iterator(ChannelTypeEnum type);
}
