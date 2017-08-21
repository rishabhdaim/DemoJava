/**
 * 
 */
package json.jackson;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 * @author Rishabh.Daim
 *
 */
public class JsonToString {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		
		List<FieldItem> errors = new LinkedList<>();
		FieldItem item1 = new FieldItem("cpMemberId", "Error");
		FieldItem item2 = new FieldItem("LegalEntityId", "Error");
		FieldItem item3 = new FieldItem("memberId", "Error");
		FieldItem item4 = new FieldItem("securityId", "Error");
		errors.add(item1);
		errors.add(item2);
		errors.add(item3);
		errors.add(item4);
		
		List<FieldItem> warnings = new LinkedList<>();
		FieldItem item5 = new FieldItem("cpMemberId", "warning");
		FieldItem item6 = new FieldItem("LegalEntityId", "warning");
		FieldItem item7 = new FieldItem("memberId", "warning");
		FieldItem item8 = new FieldItem("securityId", "warning");
		warnings.add(item5);
		warnings.add(item6);
		warnings.add(item7);
		warnings.add(item8);
		
		StatusMsg msg = new StatusMsg();
		msg.setError(errors);
		msg.setWarning(warnings);
		
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = writer.writeValueAsString(msg);
		System.out.println(json);
		
	}	
}
