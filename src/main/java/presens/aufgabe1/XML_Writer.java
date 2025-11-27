package presens.aufgabe1;
/*
 * Author : Yurii Gruzevych
 * Mat. Num. 20367
 * */

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

public class XML_Writer {
	public void writeXML(List <Person> _persons) {
		try(PrintWriter out = new PrintWriter("/home/evycham/Studium/3. Semester/Software Lab/labor4/src/main/java/presens/aufgabe1/xml/personen.xml")) {
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<personen>");
            for(Person person : _persons) {

				if(person.getId() == -1){
					out.println(" <person id=\"Ungültig\">");
				} else {
					out.println(" <person id=\"" +  person.getId() + "\">");
				}

				out.println("  <nachname>" + person.getName() + "</nachname>");
				out.println("  <vorname>" + person.getVorname() + "</vorname>");
				if(person.getGeburtsdatum() == null) {
					out.println("  <geburtsdatum>Ungültig</geburtsdatum>");
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
					out.println("  <geburtsdatum>" + sdf.format(person.getGeburtsdatum()) + "</geburtsdatum>");
				}

				out.println("  <postleitzahl>" + person.getPostleitzahl() + "</postleitzahl>");
				out.println("  <ort>" +   person.getOrt() + "</ort>");
				out.println("  <hobby>"+ person.getHobby() + "</hobby>");
				out.println("  <lieblingsgericht>" + person.getLieblingsgericht() + "</lieblingsgericht>");
				out.println("  <lieblingsband>" +   person.getLieblingsband() + "</lieblingsband>");
				out.println(" </person>");
			}
            out.println("</personen>");
        } catch(Exception e) {
			System.err.println(e);
		}
	}
}
