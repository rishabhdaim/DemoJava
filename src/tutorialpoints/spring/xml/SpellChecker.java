/**
 * 
 */
package tutorialpoints.spring.xml;

/**
 * @author Rishabh.Daim
 *
 */
public class SpellChecker {
	
	public SpellChecker() {
		System.out.println("Inside SpellChecker constructor.");
	}

	public void checkSpelling() {
		System.out.println("Inside checkSpelling.");
	}
	
	public void init() {
		System.out.println("Init Spell Checker bean");
	}
	
	public void destroy() {
		System.out.println("destroy Spell Checker bean");
	}
}
