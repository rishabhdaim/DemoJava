/**
 * 
 */
package demo.java.json.jackson;


/**
 * @author Rishabh.Daim
 *
 */
public class FieldItem {
	
	private final String field;
	private final String message;
	/**
	 * @param field
	 * @param message
	 */
	public FieldItem(String field, String message) {
		this.field = field;
		this.message = message;
	}
	/**
	 * @return the field
	 */
	public final String getField() {
		return field;
	}
	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("{field:%s, message:%s}", field, message);
	}
}
