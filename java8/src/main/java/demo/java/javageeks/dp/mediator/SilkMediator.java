/**
 * 
 */
package demo.java.javageeks.dp.mediator;

/**
 * @author Rishabh.Daim
 *
 */
public class SilkMediator implements MachineMediator {
	
	private final Machine machine;
	private final Heater heater;
	private final Motor motor;
	private final Sensor sensor;
	private final SoilRemoval soilRemoval;
	private final Valve valve;
	
	

	/**
	 * @param machine
	 * @param heater
	 * @param motor
	 * @param sensor
	 * @param soilRemoval
	 * @param valve
	 */
	public SilkMediator(Machine machine, Heater heater, Motor motor,
			Sensor sensor, SoilRemoval soilRemoval, Valve valve) {
		this.machine = machine;
		this.heater = heater;
		this.motor = motor;
		this.sensor = sensor;
		this.soilRemoval = soilRemoval;
		this.valve = valve;
		System.out.println("Setting up for SILK program");
	}

	@Override
	public void start() {
		machine.start();
	}

	@Override
	public void wash() {
		motor.startMotor();
		motor.rotateDrum(700);
		System.out.println("Adding detergent");
		soilRemoval.medium();
		System.out.println("Mild softener is added");
	}

	@Override
	public void open() {
		valve.open();
	}

	@Override
	public void closed() {
		valve.closed();
	}

	@Override
	public void on() {
		heater.on(50);
	}

	@Override
	public void off() {
		heater.off();
	}

	@Override
	public boolean checkTemperature(int temp) {
		return sensor.checkTemperature(temp);
	}

}
