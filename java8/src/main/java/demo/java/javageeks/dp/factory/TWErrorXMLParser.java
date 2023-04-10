/**
 * 
 */
package demo.java.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class TWErrorXMLParser implements XMLParser {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.XMLParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("TW Parsing error XML...");
		return "TW Error XML Message";
	}

}
