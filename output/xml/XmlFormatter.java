/**
 * 
 */
package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * @author rishabh.daim
 * 
 */
public class XmlFormatter {

	/**
	 * @param args
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws IOException,
			ParserConfigurationException, SAXException {
		XmlFormatter formatter = new XmlFormatter();
		String book = "<?xml version=\"1.0\"?><catalog><book id=\"bk101\">"
				+ "<author>Gambardella, Matthew</author><title>XML Developers Guide</title>"
				+ "<genre>Computer</genre><price>44.95</price>"
				+ "<publish_date>2000-10-01</publish_date><description>"
				+ "An in-depth look at creating applications with XML.</description>"
				+ "</book><book id=\"bk102\"><author>Ralls, Kim</author><title>"
				+ "Midnight Rain</title><genre>Fantasy</genre><price>5.95</price>"
				+ "<publish_date>2000-12-16</publish_date><description>"
				+ "A former architect battles corporate zombies, an evil sorceress, "
				+ "and her own childhood to become queen of the world.</description>"
				+ "</book></catalog>";
		System.out.println(formatter.format(book));
	}

	/**
	 * @param book
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	private String format(String unformattedXml) throws IOException,
			ParserConfigurationException, SAXException {
		Document document = parseXmlFile(unformattedXml);
		OutputFormat format = new OutputFormat(document);
		format.setLineWidth(65);
		format.setIndenting(true);
		format.setIndent(2);
		Writer out = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(out, format);
		serializer.serialize(document);
		File file = new File("formatted.xml");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(out.toString());
		fileWriter.close();
		return out.toString();
	}

	/**
	 * @param unformattedXml
	 * @return
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private Document parseXmlFile(String unformattedXml)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(unformattedXml));
		return db.parse(is);
	}

	/**
	 * * Takes an XML Document object and makes an XML String. Just a utility *
	 * function. * * @param doc - The DOM document * @return the XML String
	 * 
	 * @throws TransformerException
	 */
	public String makeXMLString(Document doc) throws TransformerException {
		String xmlString = "";
		if (doc != null) {
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			xmlString = sw.toString();
		}
		return xmlString;
	}
}
