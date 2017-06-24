package RoosterSysteem.Model.school;

import java.io.Serializable;


public class School implements Serializable {
    private String naam;
    private String adres;
    private String plaats;
    private long telefoonNummer;

    public School() {
    }

    public School(String naam, String adres, String plaats, long telefoonNummer) {
        this.naam = naam;
        this.adres = adres;
        this.plaats = plaats;
        this.telefoonNummer = telefoonNummer;
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

    public long getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(long telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (telefoonNummer != school.telefoonNummer) return false;
        if (naam != null ? !naam.equals(school.naam) : school.naam != null) return false;
        if (adres != null ? !adres.equals(school.adres) : school.adres != null) return false;
        return plaats != null ? plaats.equals(school.plaats) : school.plaats == null;
    }

    @Override
    public int hashCode() {
        int result = naam != null ? naam.hashCode() : 0;
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (plaats != null ? plaats.hashCode() : 0);
        result = 31 * result + (int) (telefoonNummer ^ (telefoonNummer >>> 32));
        return result;
    }
}
