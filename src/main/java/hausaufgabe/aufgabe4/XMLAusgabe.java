package hausaufgabe.aufgabe4;

import java.util.ArrayList;
import java.util.List;

public class XMLAusgabe {

	public static void Main(String[] args) throws Exception {


		List<Teammate> team = new ArrayList<>();

		String eingabe = "<team>\n" + "<person><vorname>Peter</vorname><nachname>Quill</nachname><alias>Starlord</al\n" + "ias></person>\n" + "<person><vorname>Rocket</vorname><nachname>Racoon</nachname><alias>---\n" + "</alias></person></team>";


		String input = eingabe.trim();

		//		// Vorprüfung
		//		int openTest = 0;
		//		int closeTest = 0;
		//		int closeTest2 = 0;
		//
		//		for(int i = 0; i < input.length(); i++) {
		//		 if(eingabe.trim().charAt(i) == '<') {
		//			 openTest++;
		//		 }
		//		 else if(input.charAt(i) == '>') {
		//			 closeTest++;
		//		 }
		//		 else if(input.charAt(i) == '/') {
		//			 closeTest2++;
		//		 }
		//		}
		//
		//		if(openTest != closeTest || closeTest2 != closeTest) {
		//			throw new Exception("Ein Tag wurde nicht geschlossen oder Flasche eingabe!");
		//		}
		//

		String objects = "team";
		String object = "person";

		int index = input.indexOf("<" + objects + ">");

	}
}
