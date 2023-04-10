/**
 * 
 */
package demo.java.java8;

/**
 * @author Rishabh.Daim
 *
 */
public class SimpleFunInterfaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		carryOutWork(new ComplexFunctionalInterface() {

			@Override
			public void add(int a, int b) {
				System.out.print("without lambda's : ");
				System.out.println(a + b);
			}
		});

		carryOutWork((e1, e2) -> System.out.println("with lambda's : "
				+ (e1 + e2)));
	}

	public static void carryOutWork(
			ComplexFunctionalInterface complexFunctionalInterface) {
		complexFunctionalInterface.add(12, 15);
	}
}