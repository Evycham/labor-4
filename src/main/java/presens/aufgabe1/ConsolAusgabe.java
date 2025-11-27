package presens.aufgabe1;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConsolAusgabe {
	public void printXML(List<Person> persons){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		System.out.println("<personen>");

		for(Person person : persons){
			if(person.getId() == -1){
				System.out.println(" <person id=\"Ungültig\">");
			} else {
				System.out.println(" <person id=\"" +  person.getId() + "\">");
			}

			System.out.println("  <nachname>" + person.getName() + "</nachname>");
			System.out.println("  <vorname>" + person.getVorname() + "</vorname>");
			if(person.getGeburtsdatum() == null) {
				System.out.println("  <geburtsdatum>Ungültig</geburtsdatum>");
			} else {
				System.out.println("  <geburtsdatum>" + sdf.format(person.getGeburtsdatum()) + "</geburtsdatum>");
			}

			System.out.println("  <postleitzahl>" + person.getPostleitzahl() + "</postleitzahl>");
			System.out.println("  <ort>" +   person.getOrt() + "</ort>");
			System.out.println("  <hobby>"+ person.getHobby() + "</hobby>");
			System.out.println("  <lieblingsgericht>" + person.getLieblingsgericht() + "</lieblingsgericht>");
			System.out.println("  <lieblingsband>" +   person.getLieblingsband() + "</lieblingsband>");
			System.out.println(" </person>");
		}
		System.out.println("</personen>");
	}
}
