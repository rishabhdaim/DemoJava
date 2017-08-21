/**
 * 
 */
package javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class DefaultParserFactory implements AbstractParserFactory {

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
			return new ErrorXMLParser();
		case FEEDBACK:
			return new FeedbackXMLParser();
		case ORDER:
			return new OrderXMLParser();
		case RESPONSE:
			return new ResponseXMLParser();
		}
		return null;
	}

}
