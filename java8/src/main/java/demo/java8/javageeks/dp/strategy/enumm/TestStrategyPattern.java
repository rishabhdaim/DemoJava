/**
 * 
 */
package demo.java8.javageeks.dp.strategy.enumm;

/**
 * @author Rishabh.Daim
 *
 */
public class TestStrategyPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TextFormatter formatter = new CapTextFormatter();
		TextEditor editor = new TextEditor(formatter);
		editor.publishText("Testing text in caps formatter");
		formatter = new LowerTextFormatter();
		editor = new TextEditor(formatter);
		editor.publishText("Testing text in lower formatter");
	}

}
