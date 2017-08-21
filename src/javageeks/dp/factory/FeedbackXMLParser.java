/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class FeedbackXMLParser implements XMLParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javageeks.dp.factory.XmlParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("Parsing feedback XML...");
		return "Feedback XML Message";
	}

}
