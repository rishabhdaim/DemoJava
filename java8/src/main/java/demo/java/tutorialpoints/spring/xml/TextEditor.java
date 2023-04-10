/**
 * 
 */
package demo.java.tutorialpoints.spring.xml;

/**
 * @author Rishabh.Daim
 *
 */
public class TextEditor {

	private final SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker, String editorName) {
		System.out.println("Inside TextEditor constructor : " + editorName);
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
