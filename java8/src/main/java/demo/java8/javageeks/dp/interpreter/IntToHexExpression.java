/**
 * 
 */
package demo.java8.javageeks.dp.interpreter;

/**
 * @author rishabh.daim
 * 
 */
public class IntToHexExpression implements Expression {

	private int i;

	/**
	 * @param i
	 */
	public IntToHexExpression(int i) {
		super();
		this.i = i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interpreterdp.Expression#interpret(interpreterdp.InterpreterContext)
	 */
	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getHexadecimalFormat(i);
	}
}