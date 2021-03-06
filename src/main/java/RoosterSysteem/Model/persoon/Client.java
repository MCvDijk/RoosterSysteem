package RoosterSysteem.Model.persoon;
import RoosterSysteem.Model.school.School;

import java.io.Serializable;


public class Client extends Persoon implements Serializable {
    private String medicijn;
    private String verzorger;
    private School school;

    public Client() {
    }

    public Client(String voornaam, String achternaam, String adres, String plaats, String email, long telefoonNummer, String medicijn, String verzorger, School school) {
        super(voornaam, achternaam, adres, plaats, email, telefoonNummer);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        if (medicijn != null ? !medicijn.equals(client.medicijn) : client.medicijn != null) return false;
        if (verzorger != null ? !verzorger.equals(client.verzorger) : client.verzorger != null) return false;
        return school != null ? school.equals(client.school) : client.school == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (medicijn != null ? medicijn.hashCode() : 0);
        result = 31 * result + (verzorger != null ? verzorger.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        return result;
    }
}
