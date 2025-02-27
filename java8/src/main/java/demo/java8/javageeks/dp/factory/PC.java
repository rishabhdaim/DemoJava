/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author rishabh.daim
 * 
 */
public class PC implements Computer {
	private String ram;
	private String hdd;
	private String cpu;

	/**
	 * @param ram
	 * @param hdd
	 * @param cpu
	 */
	public PC(String ram, String hdd, String cpu) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PC [");
		if (ram != null) {
			builder.append("ram=");
			builder.append(ram);
			builder.append(", ");
		}
		if (hdd != null) {
			builder.append("hdd=");
			builder.append(hdd);
			builder.append(", ");
		}
		if (cpu != null) {
			builder.append("cpu=");
			builder.append(cpu);
		}
		builder.append("]");
		return builder.toString();
	}
}