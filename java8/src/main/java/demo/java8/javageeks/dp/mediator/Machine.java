/**
 * 
 */
package demo.java8.javageeks.dp.mediator;

/**
 * @author Rishabh.Daim
 *
 */
public class Machine implements Colleague {

	private MachineMediator mediator;

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}

	public void start() {
		mediator.open();
	}

	public void wash() {
		mediator.wash();
	}

}
