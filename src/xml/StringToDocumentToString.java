/**
 * 
 */
package xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author aa49442
 * 
 */
public class StringToDocumentToString {

	/**
	 * @param args
	 * @throws TransformerException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws TransformerException,
			ParserConfigurationException, SAXException, IOException {
		final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<Emp id=\"1\"><name>Pankaj</name><age>25</age>\n"
				+ "<role>Developer</role><gen>Male</gen></Emp>";
		Document doc = convertStringToDocument(xmlStr);
		String str = convertDocumentToString(doc);
		System.out.println(str);
	}

	/**
	 * @param doc
	 * @return
	 * @throws TransformerException
	 */
	private static String convertDocumentToString(Document doc)
			throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		// below code to remove XML declaration
		// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
		// "yes");
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		return writer.getBuffer().toString();
	}

	/**
	 * @param xmlStr
	 * @return
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private static Document convertStringToDocument(String xmlStr)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.parse(new InputSource(
				new StringReader(xmlStr)));
		return document;
	}

}
