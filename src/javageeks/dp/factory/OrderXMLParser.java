/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class OrderXMLParser implements XMLParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javageeks.dp.factory.XmlParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("Parsing order XML...");
		return "Order XML Message";
	}

}
