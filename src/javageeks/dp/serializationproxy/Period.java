/**
 * 
 */
package javageeks.dp.serializationproxy;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aa49442
 * 
 */
public class Period implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Map<String, Object> map;
	private final Date start;
	private final Date end;

	/**
	 * @param start
	 * @param end
	 */
	public Period(Date start, Date end) {
		super();
		if (start.compareTo(end) > 0)
			throw new IllegalArgumentException();
		System.out.println("inside");
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		map = new HashMap<String, Object>();
		map.put("asdsad",new Object());
		map.put("asdsadv",new Object());
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return new Date(start.getTime());
	}

	/**
	 * @return the end
	 */
	public Date getEnd() {
		return new Date(end.getTime());
	}

	private static class SerializationProxy implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2543322166505179924L;
		private final Date start;
		private final Date end;

		/**
		 * 
		 */
		public SerializationProxy(Period p) {
			super();
			this.start = p.start;
			this.end = p.end;
		}

		private Object readResolve() {
			return new Period(start, end);
		}
	}

	private Object writeReplace() {
		return new SerializationProxy(this);
	}

	private void readObject(ObjectInputStream ois)
			throws InvalidObjectException {
		throw new InvalidObjectException("proxy required..");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Period [map=%s, start=%s, end=%s]", map, start,
				end);
	}
}
