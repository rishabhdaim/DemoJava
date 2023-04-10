/**
 * 
 */
package demo.java.tutorialpoints.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import demo.java.tutorialpoints.spring.annotation.TextEditor;
import demo.java.tutorialpoints.spring.xml.SpellChecker;

/**
 * @author Rishabh.Daim
 *
 */
@Configuration
public class TextEditorConfig {
	
	@Bean
	@Scope("singleton")
	public TextEditor textEditor() {
		return new TextEditor(spellChecker());
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
}
