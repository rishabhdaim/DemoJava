/**
 * 
 */
package demo.java.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class ErrorXMLParser implements XMLParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javageeks.dp.factory.XmlParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("Parsing error XML...");
		return "Error XML Message";
	}

}
