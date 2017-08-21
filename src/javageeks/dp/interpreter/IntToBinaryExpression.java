/**
 * 
 */
package javageeks.dp.interpreter;

/**
 * @author aa49442
 * 
 */
public class IntToBinaryExpression implements Expression {

	private int i;

	/**
	 * @param i
	 */
	public IntToBinaryExpression(int i) {
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
		return ic.getBinaryFormat(this.i);
	}
}