/**
 * 
 */
package demo.java8.javageeks.dp.factory;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Rishabh.Daim
 *
 */
public class TestAbstractFactoryPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory(ParserFactoryType.NEW_YORK);
		XMLParser parser = parserFactory.getParserInstance(ParserType.ORDER);
		String msg = StringUtils.EMPTY;
		msg = parser.parse();
		System.out.println(msg);
		System.out.println("************************************");
		parserFactory = ParserFactoryProducer.getFactory(ParserFactoryType.DEFAULT);
		parser = parserFactory.getParserInstance(ParserType.FEEDBACK);
		msg = parser.parse();
		System.out.println(msg);
	}

}
