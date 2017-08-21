package demo;

public class EmployeeVal {
	private final String profession;

	public EmployeeVal(String profession) {
		super();
		this.profession = profession;
	}

	public String getProfession() {
		return profession;
	}

	private int hashcode;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (0 != hashcode) {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((profession == null) ? 0 : profession.hashCode());
			hashcode = result;
		}
		return hashcode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EmployeeVal other = (EmployeeVal) obj;
		if (profession == null) {
			if (other.profession != null) {
				return false;
			}
		} else if (!profession.equals(other.profession)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeVal [profession=" + profession + "]";
	}
}
