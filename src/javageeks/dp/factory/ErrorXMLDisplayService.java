/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class ErrorXMLDisplayService implements DisplayService {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.DisplayService#getParser()
	 */
	@Override
	public XMLParser getParser() {
		return new ErrorXMLParser();
	}

}
