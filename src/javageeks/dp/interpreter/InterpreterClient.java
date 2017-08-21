/**
 * 
 */
package javageeks.dp.interpreter;

/**
 * @author aa49442
 * 
 */
public class InterpreterClient {

	private InterpreterContext ic;

	/**
	 * @param ic
	 */
	public InterpreterClient(InterpreterContext ic) {
		super();
		this.ic = ic;
	}

	private String interpret(String str) {
		Expression exp = null;
		// create rules for expressions
		if (str.contains("Hexadecimal"))
			exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		else if (str.contains("Binary"))
			exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		else if (str.contains("Octal"))
			exp = new IntToOctalExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		else
			return str;
		return exp.interpret(ic);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str1 = "238 in Binary";
		String str2 = "28 in Hexadecimal";
		String str3 = "345 in Octal";
		final InterpreterClient ec = new InterpreterClient(new InterpreterContext());
		System.out.println(str1 + " = " + ec.interpret(str1));
		System.out.println(str2 + " = " + ec.interpret(str2));
		System.out.println(str3 + " = " + ec.interpret(str3));
	}
}