/**
 * 
 */
package demo.java8.javageeks.dp.strategy.enumm;

/**
 * @author Rishabh.Daim
 *
 */
public class TextEditor {
	
	private final TextFormatter textFormatter;

	public TextEditor(TextFormatter textFormatter) {
		this.textFormatter = textFormatter;
	}

	public void publishText(String text) {
		textFormatter.format(text);
	}
}
