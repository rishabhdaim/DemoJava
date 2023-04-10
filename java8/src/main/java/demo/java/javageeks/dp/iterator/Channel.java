/**
 * 
 */
package demo.java.javageeks.dp.iterator;

/**
 * @author rishabh.daim
 * 
 */
public class Channel {
	
	private double frequency;
	private ChannelTypeEnum TYPE;

	/**
	 * @param frequency
	 * @param tYPE
	 */
	public Channel(double frequency, ChannelTypeEnum tYPE) {
		super();
		this.frequency = frequency;
		TYPE = tYPE;
	}

	/**
	 * @return the frequency
	 */
	public double getFrequency() {
		return frequency;
	}

	/**
	 * @return the tYPE
	 */
	public ChannelTypeEnum getTYPE() {
		return TYPE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Channel [frequency=" + frequency + ", TYPE=" + TYPE + "]";
	}
}
