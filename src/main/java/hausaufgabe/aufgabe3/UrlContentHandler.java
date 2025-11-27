package hausaufgabe.aufgabe3;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class UrlContentHandler implements ContentHandler {

	private String currentValue = null;
	List<String> titels = new ArrayList<String>();
	private boolean inItem = false;
	private boolean inTitle = false;

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(inTitle) {
			currentValue += new String(ch, start, length);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(localName.equals("item")){
			inItem = true;
		}

		if(inItem && localName.equals("title")){
			currentValue = "";
			inTitle = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName.equals("title")) {
			titels.add(currentValue);
			inTitle = false;
		}

		if(localName.equals("item")) {
			inItem = false;
		}
	}

	public void print() {
		for(String titel : titels) {
			if(titel == null || titel.trim().isBlank()) {
				continue;
			}
			System.out.println(titel + "\n");
		}
	}

	public void endDocument() throws SAXException {
	}

	public void endPrefixMapping(String prefix) throws SAXException {
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
	}

	public void processingInstruction(String target, String data) throws SAXException {
	}

	public void setDocumentLocator(Locator locator) {
	}

	public void skippedEntity(String name) throws SAXException {
	}

	public void startDocument() throws SAXException {
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
	}

}