/**
 * 
 */
package javageeks.dp.mediator;

/**
 * @author Rishabh.Daim
 *
 */
public class TestMediator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MachineMediator mediator = null;
		Sensor sensor = new Sensor();
		SoilRemoval soilRemoval = new SoilRemoval();
		Motor motor = new Motor();
		Machine machine = new Machine();
		Heater heater = new Heater();
		Valve valve = new Valve();
		Button button = new Button();
		
		mediator = MediatorFactory.getMediator(MediatorType.COTTON, machine, heater, motor, sensor, soilRemoval, valve);
		button.setMediator(mediator);
		machine.setMediator(mediator);
		heater.setMediator(mediator);
		valve.setMediator(mediator);
		button.press();
		System.out.println();
		
		mediator = MediatorFactory.getMediator(MediatorType.DENIM, machine, heater, motor, sensor, soilRemoval, valve);
		button.setMediator(mediator);
		machine.setMediator(mediator);
		heater.setMediator(mediator);
		valve.setMediator(mediator);
		button.press();
		System.out.println();
		
		mediator = MediatorFactory.getMediator(MediatorType.SILK, machine, heater, motor, sensor, soilRemoval, valve);
		button.setMediator(mediator);
		machine.setMediator(mediator);
		heater.setMediator(mediator);
		valve.setMediator(mediator);
		button.press();
	}

}
