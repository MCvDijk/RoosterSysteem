package RoosterSysteem.model.school;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class School {
    private String voornaam;
    private String achternaam;
    private String adres;
    private String plaats;
    private int telefoonNummer;

    public School(String voornaam, String achternaam, String adres, String plaats, int telefoonNummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.plaats = plaats;
        this.telefoonNummer = telefoonNummer;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
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
