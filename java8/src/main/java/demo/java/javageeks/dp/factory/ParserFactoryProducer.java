/**
 * 
 */
package demo.java.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public final class ParserFactoryProducer {

	private ParserFactoryProducer() {
		throw new AssertionError();
	}

	public static AbstractParserFactory getFactory(final ParserFactoryType factoryType) {
		switch (factoryType) {
		case NEW_YORK:
			return new NYParserFactory();
		case TOKYO:
			return new TWParserFactory();
		default:
			return new DefaultParserFactory();
		}
	}

}
