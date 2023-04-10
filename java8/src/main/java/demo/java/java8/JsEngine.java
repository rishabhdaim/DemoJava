/**
 * 
 */
package demo.java.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Rishabh.Daim
 *
 */
public class JsEngine {

	/**
	 * @param args
	 * @throws ScriptException
	 */
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager
				.getEngineByName("JavaScript");
		System.out.println(scriptEngine.getClass().getName());
		System.out.println("Result : "
				+ scriptEngine.eval("function f() { return 1; }; f() + 1;"));
	}
}