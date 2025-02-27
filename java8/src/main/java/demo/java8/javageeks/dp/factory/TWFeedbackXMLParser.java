/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class TWFeedbackXMLParser implements XMLParser {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.XMLParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("TW Parsing feedback XML...");
		return "TW Feedback XML Message";
	}

}
