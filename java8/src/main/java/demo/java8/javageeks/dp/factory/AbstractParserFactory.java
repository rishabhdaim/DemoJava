/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public interface AbstractParserFactory {

	XMLParser getParserInstance(ParserType parserType);
}
