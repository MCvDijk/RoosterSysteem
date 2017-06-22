package RoosterSysteem.Model.school;

import java.io.Serializable;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class School implements Serializable {
    private String naam;
    private String adres;
    private String plaats;
    private int telefoonNummer;

    public School(String naam, String adres, String plaats, int telefoonNummer) {
        this.naam = naam;
        this.adres = adres;
        this.plaats = plaats;
        this.telefoonNummer = telefoonNummer;
    }

    public School() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public int getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(int telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }
}
