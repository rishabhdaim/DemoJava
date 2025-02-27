/**
 * 
 */
package demo.java8.javageeks.dp.prototype;

/**
 * @author Rishabh.Daim
 *
 */
public class User {
	
	private final String userName;
	private AccessLevel level;
	private AccessControl accessControl;

	/**
	 * @param userName
	 * @param level
	 * @param accessControl
	 */
	public User(String userName, AccessLevel level, AccessControl accessControl) {
		this.userName = userName;
		this.level = level;
		this.accessControl = accessControl;
	}

	/**
	 * @return the level
	 */
	public final AccessLevel getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public final void setLevel(AccessLevel level) {
		this.level = level;
	}

	/**
	 * @return the accessControl
	 */
	public final AccessControl getAccessControl() {
		return accessControl;
	}

	/**
	 * @param accessControl
	 *            the accessControl to set
	 */
	public final void setAccessControl(AccessControl accessControl) {
		this.accessControl = accessControl;
	}

	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [");
		if (userName != null) {
			builder.append("userName=");
			builder.append(userName);
			builder.append(", ");
		}
		if (level != null) {
			builder.append("level=");
			builder.append(level);
			builder.append(", ");
		}
		if (accessControl != null) {
			builder.append("accessControl=");
			builder.append(accessControl);
		}
		builder.append("]");
		return builder.toString();
	}

}
