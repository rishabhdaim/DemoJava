/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author rishabh.daim
 * 
 */
public class Server implements Computer {
	private String ram;
	private String hdd;
	private String cpu;

	/**
	 * @param ram
	 * @param hdd
	 * @param cpu
	 */
	public Server(String ram, String hdd, String cpu) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see factorydp.Computer#getRAM()
	 */
	@Override
	public String getRAM() {
		return this.ram;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see factorydp.Computer#getHDD()
	 */
	@Override
	public String getHDD() {
		return this.hdd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see factorydp.Computer#getCPU()
	 */
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
		builder.append("Server [");
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