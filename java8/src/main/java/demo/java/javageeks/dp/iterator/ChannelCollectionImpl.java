/**
 * 
 */
package demo.java.javageeks.dp.iterator;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author rishabh.daim
 * 
 */
public class ChannelCollectionImpl implements ChannelCollection {

	private final List<Channel> channelsList;

	public ChannelCollectionImpl() {
		channelsList = Lists.newArrayList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iteratordp.ChannelCollection#addChannel(iteratordp.Channel)
	 */
	@Override
	public void addChannel(Channel c) {
		channelsList.add(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iteratordp.ChannelCollection#removeChannel(iteratordp.Channel)
	 */
	@Override
	public void removeChannel(Channel c) {
		channelsList.remove(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iteratordp.ChannelCollection#iterator(iteratordp.ChannelTypeEnum)
	 */
	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, this.channelsList);
	}
	
	// iterator below
	/**
	 * @author rishabh.daim
	 * 
	 */
	private class ChannelIteratorImpl implements ChannelIterator {

		private final ChannelTypeEnum type;
		private final List<Channel> channels;
		private int position;
		private Channel lastReturned, next = null;

		public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> channelsList) {
			this.type = type;
			this.channels = channelsList;
			this.position = 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see iteratordp.ChannelIterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			while (position < this.channels.size()) {
				final Channel channel = this.channels.get(position);
				if (type.equals(channel.getTYPE()) || type.equals(ChannelTypeEnum.ALL))
					return true;
				else
					position++;
			}
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see iteratordp.ChannelIterator#next()
		 */
		@Override
		public Channel next() {
			next = this.channels.get(position++);
			lastReturned = next;
			return lastReturned;
		}

		@Override
		public Channel remove() {
			if (lastReturned == null)
				throw new IllegalStateException();
			final Channel temp = lastReturned;
			ChannelCollectionImpl.this.removeChannel(lastReturned);
			lastReturned = null;
			return temp;
		}
	}
}
