/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class FeedbackXMLDisplayService implements DisplayService {

	/* (non-Javadoc)
	 * @see javageeks.dp.factory.DisplayService#getParser()
	 */
	@Override
	public XMLParser getParser() {
		return new FeedbackXMLParser();
	}

}
