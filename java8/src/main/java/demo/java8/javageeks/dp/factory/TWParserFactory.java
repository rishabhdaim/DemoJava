/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class TWParserFactory implements AbstractParserFactory {

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
			return new TWErrorXMLParser();
		case FEEDBACK:
			return new TWFeedbackXMLParser();
		case ORDER:
			return new TWOrderXMLParser();
		case RESPONSE:
			return new TWResponseXMLParser();
		}
		return null;
	}

}
