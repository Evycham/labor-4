package presens.aufgabe1;

/*
* Author : Yurii Gruzevych
* Mat. Num. 20367
* */

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main() throws Exception {
        Scanner input = new Scanner(System.in);

        PersonenContentHandler contentHandler = new PersonenContentHandler();

        XMLReader reader = XMLReaderFactory.createXMLReader();

        reader.setContentHandler(contentHandler);

        reader.parse(new InputSource(new FileInputStream("/home/evycham/Studium/3. Semester/Software Lab/labor4/src/main/java/presens/aufgabe1/xml/personen.xml")));

        XML_Writer xmlWriter = new XML_Writer();

        List<Person> persons = contentHandler.getAllePersonen();

        int ID;
		int maxID = 0;

        for(Person person : persons){
            if(person.getId() > maxID){
                maxID = person.getId();
            }
        }
		ID = maxID + 1;

        while(true) {
            try {
                System.out.print("\n\nBeispiel:  Name, Vorname, ID" +
                        " Geburtsdatum, Postleitzahl, Ort, Hobby," +
                        " Lieblingsgericht, Lieblingsband. (muss unbedingt 8 Kommas und ein Punkt dabei sein!)\n\nEingabe: ");
                String in = input.nextLine();

                if(in != null && in.trim().equals("stop")) {
                break;
                }

				int count = 0;
				boolean isPunkt = false;
				for(int i = 0; i < in.length(); i++) {
					if(in.charAt(i) == ',') {
						count++;
					}
					if(in.charAt(i) == '.') {
						isPunkt = true;
					}
				}

				if(count != 8 && !isPunkt) {
					throw new Exception("Falsche Eingabe.");
				}
				in = in.substring(0, in.length() - 1);
				String[] data = in.split(",");

                String firstName = data[0].trim();
                String lastName = data[1].trim();

                Date geburtsdatum = null;
                if(data[3] == null || data[3].trim().isBlank()) {
                    geburtsdatum = null;
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    geburtsdatum = sdf.parse(data[3]);
                }

                String postleitzahl = data[4].trim();
                String ort = data[5].trim();
                String hobby = data[6].trim();
                String lieblingsgericht = data[7].trim();
                String lieblingsband = data[8].trim();

                Person addP = new Person(firstName, lastName, ID, geburtsdatum, postleitzahl, ort, hobby, lieblingsgericht, lieblingsband);

                addP.setId(ID++);

                persons.add(addP);

            } catch (Exception e) {
                System.out.println("Invalid input! " + e.getMessage());
            }
        }
        xmlWriter.writeXML(persons);
        ConsolAusgabe consolAusgabe = new ConsolAusgabe();
        consolAusgabe.printXML(persons);

        input.close();
    }
}
