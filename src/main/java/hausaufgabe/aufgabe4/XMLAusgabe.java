package hausaufgabe.aufgabe4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLAusgabe {

	/**
	 * Extrahiert den Text zwischen <tag> und </tag>.
	 *
	 * @param input   XML-String, der das Tag enthält
	 * @param tagName Name des Tags ohne Klammern
	 * @return Inhalt zwischen <tagName> und </tagName>
	 * @throws Exception falls das Tag nicht gefunden wird oder fehlerhaft ist
	 */
	public String extractElement(String input, String tagName) throws Exception {
		if (input == null || tagName == null || input.trim().isBlank()) {
			throw new Exception("Falsche Eingabe!");
		}

		int start = input.indexOf("<" + tagName + ">");
		int end   = input.indexOf("</" + tagName + ">");

		if (start == -1 || end == -1) {
			throw new Exception("Tag nicht gefunden: " + tagName);
		}

		start += tagName.length() + 2; // hinter <tag>

		return input.substring(start, end).trim();
	}

	/**
	 * Extrahiert den Inhalt ALLER Vorkommen eines Tags.
	 * Beispiel: <vorname>A</vorname><vorname>B</vorname> → ["A", "B"]
	 *
	 * @param input   XML-String, z. B. der Inhalt eines <team>- oder <person>-Blocks
	 * @param tagName Name des Tags ohne Klammern
	 * @return Liste aller Inhalte der Tags
	 * @throws Exception falls End-Tags fehlen oder strukturelle Fehler auftreten
	 */
	public List<String> extractElements(String input, String tagName) throws Exception {

		List<String> result = new ArrayList<>();
		int pointer = 0;

		while (true) {

			int start = input.indexOf("<" + tagName + ">", pointer);
			if (start == -1) break;

			int end = input.indexOf("</" + tagName + ">", start);
			if (end == -1)
				throw new Exception("Endtag fehlt: " + tagName);

			int fullEnd = end + ("</" + tagName + ">").length();

			String block = input.substring(start, fullEnd);
			result.add(extractElement(block, tagName));

			pointer = fullEnd;
		}

		if (result.isEmpty()) {
			throw new Exception("Keine Elemente gefunden: " + tagName);
		}

		return result;
	}

	/**
	 * Liest eine Datei ein und entfernt äußere Leerzeichen.
	 *
	 * @param path Dateipfad
	 * @return gesamter Dateiinhalt als String
	 * @throws Exception falls die Datei nicht gelesen werden kann
	 */
	private static String readFile(String path) throws Exception {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line.trim());
			}
		}

		return sb.toString();
	}

	/**
	 * Hauptprogramm: liest XML, extrahiert Personen und gibt sie aus.
	 *
	 * @param args Kommandozeilenargumente
	 * @throws Exception bei Parsing- oder Datei-Fehlern
	 */
	public static void main(String[] args) throws Exception {

		try {
			String xml = readFile("/home/evycham/IdeaProjects/labor-4/src/main/java/hausaufgabe/aufgabe4/test.xml");

			XMLAusgabe parser = new XMLAusgabe();

			String team = parser.extractElement(xml, "team");
			List<String> persons = parser.extractElements(team, "person");

			for (String p : persons) {

				List<String> vornamen  = parser.extractElements(p, "vorname");
				List<String> nachnamen = parser.extractElements(p, "nachname");
				String alias           = parser.extractElement(p, "alias");

				String vn = String.join(" ", vornamen);
				String nn = String.join(" ", nachnamen);

				System.out.println(vn + " " + nn + " – " + alias);
			}

		} catch (Exception ex) {
			System.err.println("Fehler: " + ex.getMessage());
		}
	}
}