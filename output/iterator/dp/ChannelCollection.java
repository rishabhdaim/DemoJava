/**
 * 
 */
package iterator.dp;

/**
 * @author aa49442
 * 
 */
public interface ChannelCollection {
	public void addChannel(Channel c);

	public void removeChannel(Channel c);

	public ChannelIterator iterator(ChannelTypeEnum type);
}