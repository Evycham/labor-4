package hausaufgabe.aufgabe4;

import java.util.ArrayList;

public class Teammate {
	private String Nachname = null;
	private String Vorname = null;
	private String ZweiterVorname = null;
	private String Alias = null;

	public ArrayList<String> parametersNames(){
		ArrayList<String> res = new ArrayList<>();
		res.add("nachname");
		res.add("vorname");
		res.add("alias");
		return res;
	}

	public void setNachname(String nachname) {
		this.Nachname = nachname;
	}

	public String getNachname() {
		return this.Nachname;
	}

	public void setVorname(String vorname) {
		this.Vorname = vorname;
	}

	public String getVorname() {
		return this.Vorname;
	}

	public void setZweiterVorname(String _zweiterVorname) {
		this.ZweiterVorname = _zweiterVorname;
	}

	public String getZweiterVorname() {
		return this.ZweiterVorname;
	}

	public void setAlias(String alias) {
		this.Alias = alias;
	}

	public String getAlias() {
		return this.Alias;
	}
}
