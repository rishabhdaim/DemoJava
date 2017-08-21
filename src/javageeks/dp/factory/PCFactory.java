/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author aa49442
 * 
 */
public class PCFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public PCFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see factorydp.ComputerAbstractFactory#createComputer()
	 */
	@Override
	public Computer createComputer() {
		return new PC(ram, hdd, cpu);
	}
}