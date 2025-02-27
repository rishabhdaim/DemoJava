/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class ResponseXMLParser implements XMLParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javageeks.dp.factory.XmlParser#parse()
	 */
	@Override
	public String parse() {
		System.out.println("Parsing response XML...");
		return "Response XML Message";
	}

}
