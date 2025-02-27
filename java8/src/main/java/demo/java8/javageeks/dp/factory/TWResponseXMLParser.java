/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class TWResponseXMLParser implements XMLParser {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.XMLParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("TW Parsing response XML...");
		return "TW Response XML Message";
	}

}
