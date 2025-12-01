package hausaufgabe.aufgabe4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLAusgabe {

	public String extractElement(String _input, String _tagName) throws Exception {
		if(_input == null || _tagName == null || _input.trim().isBlank() || _tagName.trim().isBlank()){
			throw new Exception("Falsche Eingabe");
		}

		int startIdx = _input.trim().indexOf("<" + _tagName + ">");
		int endIdx = _input.trim().indexOf("</" + _tagName + ">");

		if(startIdx == -1 || endIdx == -1) {
			throw new Exception("Falsche Eingabe!");
		}
		startIdx += 2 + _tagName.length();

		return _input.substring(startIdx, endIdx).trim();
	}

	public List<String> extractElements(String _input, String _tagName) throws Exception {

		int Pointer = 0;
		ArrayList<String> allElements = new ArrayList<>();

		while(true){
			int startIdx = _input.trim().indexOf("<" + _tagName + ">", Pointer);
			if(startIdx == -1){
				System.err.println("Falsche Eingabe vom Tag (existiert nicht)!");
				break;
			}

			int endIdx = _input.trim().indexOf("</" + _tagName + ">", startIdx);

			if(endIdx == -1){
				throw new Exception("Falsche Eingabe! (keinen End-Tag gefunden)");
			}

			endIdx += 3 + _tagName.length();

			String element = _input.substring(startIdx, endIdx).trim();
			allElements.add(extractElement(element, _tagName));
			Pointer = endIdx + _tagName.length() + 3;
		}

		if(allElements.isEmpty()){
			throw new Exception("Keine Eingabe!");
		}
		return allElements;
	}

	public static void main(String[] args) throws Exception {
		try {
			StringBuilder sb = new StringBuilder();

			try(BufferedReader br = new BufferedReader(new FileReader("/home/evycham/Studium/3. Semester/Software Lab/labor4/src/main/java/hausaufgabe/aufgabe4/test.xml"))) {
				String line;
				while((line = br.readLine()) != null) {
					sb.append(line.trim());
				}
			}

			String xml = sb.toString();

			XMLAusgabe xmlAusgabe = new XMLAusgabe();

			String teamInput = xmlAusgabe.extractElement(xml, "team");

			List<String> personsInput = xmlAusgabe.extractElements(teamInput, "person");

			for(String p : personsInput) {
				List<String> vornamen = xmlAusgabe.extractElements(p, "vorname");
				String nachname = xmlAusgabe.extractElement(p, "nachname");
				String alias = xmlAusgabe.extractElement(p, "alias");
				if(vornamen.size() > 1 && vornamen.get(1) == null) {
					vornamen.add(1, "-");
				}
				System.out.println(vornamen.toString() + " " + nachname + " " + alias);
			}
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
