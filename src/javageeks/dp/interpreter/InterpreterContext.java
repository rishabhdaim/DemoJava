/**
 * 
 */
package javageeks.dp.interpreter;

/**
 * @author aa49442
 * 
 */
public class InterpreterContext {
	public String getBinaryFormat(int i) {
		return Integer.toBinaryString(i);
	}

	public String getHexadecimalFormat(int i) {
		return Integer.toHexString(i);
	}
	
	public String getOctalFormat(int i) {
		return Integer.toOctalString(i);
	}
}
