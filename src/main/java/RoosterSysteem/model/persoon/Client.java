package RoosterSysteem.model.persoon;

import RoosterSysteem.model.school.School;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class Client extends Persoon{
    private String medicijn;
    private String verzorger;
    private School school;

    public Client() {
    }

    public Client(String voornaam, String achternaam, String adres, String plaats, String wachtwoord, String gebruikersnaam, String email, int telefoonNummer, String medicijn, String verzorger, School school) {
        super(voornaam, achternaam, adres, plaats, wachtwoord, gebruikersnaam, email, telefoonNummer);
        this.medicijn = medicijn;
        this.verzorger = verzorger;
        this.school = school;
    }

    public String getMedicijn() {
        return medicijn;
    }

    public void setMedicijn(String medicijn) {
        this.medicijn = medicijn;
    }

    public String getVerzorger() {
        return verzorger;
    }

    public void setVerzorger(String verzorger) {
        this.verzorger = verzorger;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
