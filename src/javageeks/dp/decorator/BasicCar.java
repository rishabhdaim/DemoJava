/**
 * 
 */
package javageeks.dp.decorator;

/**
 * @author aa49442
 * 
 */
public class BasicCar implements Car {

	/*
	 * (non-Javadoc)
	 * 
	 * @see decoratordp.Car#assemble()
	 */
	@Override
	public void assemble() {
		System.out.print("Basic Car.");
	}

}
