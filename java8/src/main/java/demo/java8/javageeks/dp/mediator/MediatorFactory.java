/**
 * 
 */
package demo.java8.javageeks.dp.mediator;

/**
 * @author Rishabh.Daim
 *
 */
public class MediatorFactory {

	public static MachineMediator getMediator(final MediatorType mediatorType,
			final Machine machine, final Heater heater, final Motor motor,
			final Sensor sensor, final SoilRemoval soilRemoval,
			final Valve valve) {
		
		final MachineMediator mediator;
		switch (mediatorType) {
		case COTTON:
			mediator = new CottonMediator(machine, heater, motor, sensor, soilRemoval, valve);
			return mediator;

		case DENIM:

			mediator = new DenimMediator(machine, heater, motor, sensor, soilRemoval, valve);
			return mediator;

		case SILK:

			mediator = new SilkMediator(machine, heater, motor, sensor, soilRemoval, valve);
			return mediator;

		default:
			mediator = null;
			return mediator;
		}

	}
}
