/**
 * 
 */
package demo.java.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public interface AbstractParserFactory {

	XMLParser getParserInstance(ParserType parserType);
}
