/**
 * 
 */
package demo.java.json.jackson;

import java.util.List;

/**
 * @author Rishabh.Daim
 *
 */
public class StatusMsg {
	
	private List<FieldItem> error;
	private List<FieldItem> warning;
	/**
	 * @return the error
	 */
	public final List<FieldItem> getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public final void setError(List<FieldItem> error) {
		this.error = error;
	}
	/**
	 * @return the warning
	 */
	public final List<FieldItem> getWarning() {
		return warning;
	}
	/**
	 * @param warning the warning to set
	 */
	public final void setWarning(List<FieldItem> warning) {
		this.warning = warning;
	}

	@Override
	public String toString() {
		return String.format("{error:%s, warning:%s}", error, warning);
	}
}
