/**
 * 
 */
package demo.java.javageeks.dp.builder;

/**
 * @author Rishabh.Daim
 *
 */
public class TestBuilderPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CarBuilder carBuilder = new SedanCarBuilder();
		CarDirector director = new CarDirector(carBuilder);
		director.build();
		Car car = carBuilder.buildCar();
		System.out.println(car);
		carBuilder = new SportsCarBuilder();
		director = new CarDirector(carBuilder);
		director.build();
		car = carBuilder.buildCar();
		System.out.println(car);
	}
}
