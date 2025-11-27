package presens.aufgabe1;

/*
 * Author : Yurii Gruzevych
 * Mat. Num. 20367
 * */

import java.util.Date;

public class Person {
    private String firstName = null;
    private String lastName = null;
    private int ID = 0;
    private Date geburtsdatum = null;
    private String postleitzahl = null;
    private String ort = null;

    private String hobby = null;
    private String lieblingsgericht = null;
    private String lieblingsband = null;

    public Person() {}

    public Person(String _firstName, String _lastName, int _ID, Date _geburtsdatum, String _postleitzahl, String _ort, String _hobby, String _lieblingsgericht, String _lieblingsband) {
        try {
            setVorname(_firstName);
            setName(_lastName);
            setId(_ID);
            setGeburtsdatum(_geburtsdatum);
            setPostleitzahl(_postleitzahl);
            setOrt(_ort);
            setHobby(_hobby);
            setLieblingsgericht(_lieblingsgericht);
            setLieblingsband(_lieblingsband);
        } catch (Exception e) {
            System.out.println("Es ist unmöglich eine aufgabe1.Person zu erzeugen: " + e);
        }
    }

    public void setVorname(String _firstName) {
        if(_firstName == null || _firstName.trim().isBlank()) {
            firstName = "Ungültig";
        } else {
			this.firstName = _firstName;
		}
    }

    public String getVorname() {
        return this.firstName;
    }

    public void setName(String _lastName) {
        if(_lastName == null || _lastName.trim().isBlank()) {
            this.lastName = "Ungültig";
        } else{
			this.lastName = _lastName;
		}
    }

    public String getName() {
        return this.lastName;
    }

    public void setId(Integer _ID) {
			this.ID = _ID;
    }

    public int getId() {
        return this.ID;
    }

    public void setGeburtsdatum(Date _geburtsdatum) {
        this.geburtsdatum = _geburtsdatum;
    }

    public Date getGeburtsdatum() {
        return this.geburtsdatum;
    }

    public void setPostleitzahl(String _Postleitzahl) {
        if(_Postleitzahl == null || _Postleitzahl.trim().isBlank()) {
            this.postleitzahl = "Ungültig";
		} else{
			this.postleitzahl = _Postleitzahl;
		}
	}

    public String getPostleitzahl() {
        return this.postleitzahl;
    }

    public void setOrt(String _ort) {
        if(_ort == null || _ort.trim().isBlank()) {
            this.ort = "Ungültig";
        } else {
			this.ort = _ort;
		}
    }

    public String getOrt() {
        return this.ort;
    }

    public void setHobby(String _hobby) {
        if(_hobby == null || _hobby.trim().isBlank()) {
            this.hobby = "Ungültig";
        } else{
			this.hobby = _hobby;
		}
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setLieblingsgericht(String _Lieblingsgericht) {
        if(_Lieblingsgericht == null || _Lieblingsgericht.trim().isBlank()) {
            this.lieblingsgericht = "Ungültig";
        } else{
			this.lieblingsgericht = _Lieblingsgericht;
		}
    }

    public String getLieblingsgericht() {
        return this.lieblingsgericht;
    }

    public void setLieblingsband(String _Lieblingsband) {
        if(_Lieblingsband == null || _Lieblingsband.trim().isBlank()) {
            this.lieblingsband = "Ungültig";
        } else{
			this.lieblingsband = _Lieblingsband;
		}
    }

    public String getLieblingsband() {
        return this.lieblingsband;
    }
}

