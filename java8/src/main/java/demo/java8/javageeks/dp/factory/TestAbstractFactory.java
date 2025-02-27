/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author rishabh.daim
 * 
 */
public class TestAbstractFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getAbsComputer(new PCFactory("2 GB",
				"500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getAbsComputer(new ServerFactory(
				"16 GB", "1 TB", "2.9 GHz"));
		Computer laptop = ComputerFactory.getAbsComputer(new LaptopFactory(
				"1 GB", "256 GB", "2.14 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
		System.out.println("AbstractFactory Laptop Config::" + laptop);
	}
}