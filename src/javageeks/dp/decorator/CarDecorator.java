/**
 * 
 */
package javageeks.dp.decorator;

/**
 * @author aa49442
 * 
 */
public class CarDecorator implements Car {
	protected Car car;

	public CarDecorator(Car c) {
		this.car = c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see decoratordp.Car#assemble()
	 */
	@Override
	public void assemble() {
		this.car.assemble();
	}
}