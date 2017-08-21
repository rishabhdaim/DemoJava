/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class NYErrorXMLParser implements XMLParser {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.XMLParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("NY Parsing error XML...");
		return "NY Error XML Message";
	}

}
