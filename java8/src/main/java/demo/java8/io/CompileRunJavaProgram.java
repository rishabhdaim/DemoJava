/**
 * 
 */
package demo.java8.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author rishabh.daim
 * 
 */
public class CompileRunJavaProgram {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//runProcess("pwd");
		System.out.println("**********");
		runProcess("javac -cp src src/io/Test.java");
		System.out.println("**********");
		runProcess("java -cp src io/Test Hi Rishabh Daim");
	}

	private static void printLines(String cmd, InputStream ins)
			throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null)
			System.out.println(cmd + " " + line);
	}

	private static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}
}
