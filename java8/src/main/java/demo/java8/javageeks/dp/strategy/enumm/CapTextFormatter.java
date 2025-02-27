/**
 * 
 */
package demo.java8.javageeks.dp.strategy.enumm;

/**
 * @author Rishabh.Daim
 *
 */
public class CapTextFormatter implements TextFormatter {

	/* (non-Javadoc)
	 * @see javageeks.dp.strategy.enumm.TextFormatter#format(java.lang.String)
	 */
	@Override
	public void format(String text) {
		System.out.println("[CapTextFormatter]: "+text.toUpperCase());
	}

}
