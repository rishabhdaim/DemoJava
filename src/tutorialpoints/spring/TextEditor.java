/**
 * 
 */
package tutorialpoints.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class TextEditor {

	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker, String editorName) {
		System.out.println("Inside TextEditor constructor : " + editorName);
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
