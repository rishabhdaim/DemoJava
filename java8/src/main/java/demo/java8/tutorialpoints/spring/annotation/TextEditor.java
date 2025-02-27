/**
 * 
 */
package demo.java8.tutorialpoints.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import demo.java8.tutorialpoints.spring.xml.SpellChecker;

/**
 * @author Rishabh.Daim
 *
 */
public class TextEditor {

	private final SpellChecker spellChecker;
	
	// auto wiring can be used with methods & properties as well
	@Autowired
	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside Annotation TextEditor constructor");
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
