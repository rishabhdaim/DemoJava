/**
 * 
 */
package tutorialpoints.spring.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author Rishabh.Daim
 *
 */
public class TutorialFieldSetMapper implements FieldSetMapper<Tutorial> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet
	 * (org.springframework.batch.item.file.transform.FieldSet)
	 */
	@Override
	public Tutorial mapFieldSet(FieldSet fieldSet) throws BindException {
		// instantiating the Tutorial class
		final Tutorial tutorial = new Tutorial();

		// Setting the fields from XML
		tutorial.setTutorial_id(fieldSet.readInt(0));
		tutorial.setTutorial_title(fieldSet.readString(1));
		tutorial.setTutorial_author(fieldSet.readString(2));
		tutorial.setTutorial_icon(fieldSet.readString(3));
		tutorial.setTutorial_description(fieldSet.readString(4));
		return tutorial;
	}
}
