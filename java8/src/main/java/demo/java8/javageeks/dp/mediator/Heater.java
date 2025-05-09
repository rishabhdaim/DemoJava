package demo.java8.javageeks.dp.mediator;

/**
 * @author Rishabh.Daim
 *
 */
public class Heater implements Colleague {
	private MachineMediator mediator;

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}

	public void on(int temp) {
		System.out.println("Heater is on...");
		if (mediator.checkTemperature(temp)) {
			System.out.println("Temperature is set to " + temp);
			mediator.off();
		}
	}

	public void off() {
		System.out.println("Heater is off...");
		mediator.wash();
	}
}
