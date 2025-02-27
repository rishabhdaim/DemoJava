/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class ResponseXMLDisplayService implements DisplayService {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.DisplayService#getParser()
	 */
	@Override
	public XMLParser getParser() {
		return new ResponseXMLParser();
	}

}
