/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class NYParserFactory implements AbstractParserFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javageeks.dp.factory.AbstractParserFactory#getParserInstance(javageeks
	 * .dp.factory.ParserFactoryType)
	 */
	@Override
	public XMLParser getParserInstance(final ParserType parserType) {
		switch (parserType) {
		case ERROR:
			return new NYErrorXMLParser();
		case FEEDBACK:
			return new NYFeedbackXMLParser();
		case ORDER:
			return new NYOrderXMLParser();
		case RESPONSE:
			return new NYResponseXMLParser();
		}
		return null;
	}

}
