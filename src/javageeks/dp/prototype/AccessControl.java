/**
 * 
 */
package javageeks.dp.prototype;

/**
 * @author Rishabh.Daim
 *
 */
public class AccessControl implements Prototype {

	private final AccessLevel accessLevel;
	private String access;

	/**
	 * @param controlLevel
	 * @param access
	 */
	public AccessControl(AccessLevel controlLevel, String access) {
		try {
			Thread.sleep(2000); // to make this object heavier to instantiate
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.accessLevel = controlLevel;
		this.access = access;
	}

	/**
	 * @return the access
	 */
	public final String getAccess() {
		return access;
	}

	/**
	 * @param access
	 *            the access to set
	 */
	public final void setAccess(String access) {
		this.access = access;
	}

	/**
	 * @return the controlLevel
	 */
	public final AccessLevel getControlLevel() {
		return accessLevel;
	}
	
	@Override
	public AccessControl clone() {
		try {
			return (AccessControl) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccessControl [");
		if (accessLevel != null) {
			builder.append("accessLevel=");
			builder.append(accessLevel);
			builder.append(", ");
		}
		if (access != null) {
			builder.append("access=");
			builder.append(access);
		}
		builder.append("]");
		return builder.toString();
	}
}
