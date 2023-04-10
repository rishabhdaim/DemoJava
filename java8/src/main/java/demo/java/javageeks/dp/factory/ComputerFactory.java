/**
 * 
 */
package demo.java.javageeks.dp.factory;

/**
 * @author rishabh.daim
 * 
 */
public class ComputerFactory {
	public static Computer getComputer(String type, String ram, String hdd,
			String cpu) {
		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);
		return null;
	}

	public static Computer getAbsComputer(
			ComputerAbstractFactory computerAbstractFactory) {
		return computerAbstractFactory.createComputer();
	}
}