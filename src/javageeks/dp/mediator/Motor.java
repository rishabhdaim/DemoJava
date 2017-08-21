/**
 * 
 */
package javageeks.dp.mediator;

/**
 * @author Rishabh.Daim
 *
 */
public class Motor {
	
	public void startMotor() {
		System.out.println("Motor Started");
	}
	
	public void rotateDrum(int rpm) {
		System.out.println("Rotating drum @ " + rpm + " rpms");
	}
}
