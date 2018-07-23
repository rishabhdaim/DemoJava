/**
 * 
 */
package threads;

/**
 * @author rishabh.daim
 * 
 */
public class Message {
	private String msg;

	public Message(String str) {
		this.msg = str;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String str) {
		this.msg = str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [msg=" + msg + "]";
	}
}
