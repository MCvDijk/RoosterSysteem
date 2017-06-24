package RoosterSysteem.Model.persoon;

import java.io.Serializable;

public abstract class Persoon implements Serializable {

    private String voornaam;
    private String achternaam;
    private String adres;
    private String plaats;
    private String email;
    private int telefoonNummer;

    public Persoon() {
    }

    public Persoon(String voornaam, String achternaam, String adres, String plaats, String email, int telefoonNummer) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.plaats = plaats;
        this.email = email;
        this.telefoonNummer = telefoonNummer;
    }

    public String getVolledigeNaam(String voornaam,String achternaam){
        return voornaam + " " + achternaam;
    }

    public String getVoornaam() {
        return this.voornaam;
    }

    public String getAchternaam() {
        return this.achternaam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefoonNummer(int telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persoon persoon = (Persoon) o;

        if (telefoonNummer != persoon.telefoonNummer) return false;
        if (voornaam != null ? !voornaam.equals(persoon.voornaam) : persoon.voornaam != null) return false;
        if (achternaam != null ? !achternaam.equals(persoon.achternaam) : persoon.achternaam != null) return false;
        if (adres != null ? !adres.equals(persoon.adres) : persoon.adres != null) return false;
        if (plaats != null ? !plaats.equals(persoon.plaats) : persoon.plaats != null) return false;
        return email != null ? email.equals(persoon.email) : persoon.email == null;
    }

    @Override
    public int hashCode() {
        int result = voornaam != null ? voornaam.hashCode() : 0;
        result = 31 * result + (achternaam != null ? achternaam.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (plaats != null ? plaats.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + telefoonNummer;
        return result;
    }
}
