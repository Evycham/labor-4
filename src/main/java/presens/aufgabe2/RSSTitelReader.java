package presens.aufgabe2;

import hausaufgabe.aufgabe3.UrlContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class RSSTitelReader {
	public static void main() throws SAXException {
		UrlContentHandler urlContentHandler = new UrlContentHandler();

		XMLReader reader = XMLReaderFactory.createXMLReader();

		reader.setContentHandler(urlContentHandler);

		try {
			URI uri = new URI("https://rss.dw.com/xml/rss-de-all");

			URL url = uri.toURL();

			URLConnection connection = url.openConnection();

			reader.parse(new InputSource(connection.getInputStream()));

			urlContentHandler.print();

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
