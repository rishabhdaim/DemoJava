/**
 * 
 */
package demo.java.javageeks.dp.mediator;

/**
 * Interface for Washing machine mediator. Its implentation will hold all the
 * {@link Colleague} objects to be used in Washing machine.
 * 
 * All the {@link Colleague} will interact only with {@link MachineMediator} to
 * call other objects methods.
 * 
 * @author Rishabh.Daim
 *
 */
public interface MachineMediator {

	/**
	 * Start Washing machine from {@link Button}
	 */
	void start();

	/**
	 * Start washing of clothes
	 */
	void wash();

	/**
	 * open {@link Valve}
	 */
	void open();

	/**
	 * Close the {@link Valve}
	 */
	void closed();

	/**
	 * Start heater to raise temperature of water
	 */
	void on();

	/**
	 * Close heater when required temp is reached
	 */
	void off();

	/**
	 * Check temp, call off() when required temp is reached
	 * 
	 * @param temp
	 * @return
	 */
	boolean checkTemperature(int temp);

}
