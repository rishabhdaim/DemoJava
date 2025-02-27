/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class NYFeedbackXMLParser implements XMLParser {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.XMLParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("NY Parsing feedback XML...");
		return "NY Feedback XML Message";
	}

}
