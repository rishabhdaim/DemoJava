/**
 * 
 */
package demo.java.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class OrderXMLDisplayService implements DisplayService {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.DisplayService#getParser()
	 */
	@Override
	public XMLParser getParser() {
		return new OrderXMLParser();
	}

}
