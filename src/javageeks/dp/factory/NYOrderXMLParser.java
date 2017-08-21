/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class NYOrderXMLParser implements XMLParser {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.XMLParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("NY Parsing order XML...");
		return "NY Order XML Message";
	}

}
