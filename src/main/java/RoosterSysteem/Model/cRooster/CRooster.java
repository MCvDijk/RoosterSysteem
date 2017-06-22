package RoosterSysteem.Model.cRooster;

import RoosterSysteem.Model.persoon.Client;

import java.io.Serializable;
import java.time.LocalTime;

public class CRooster implements Serializable {
    private Client client;
    private int weekNummer;
    private String dag;
    private String aankomst;
    private LocalTime aankomstTijd;
    private String vertrek;
    private LocalTime vertrekTijd;
    private boolean slapen;
    private String medicijn;
    private boolean afwezig;
    private String voornaam;
    private String achternaam;

    public CRooster(Client client, int weekNummer, String dag, String aankomst, LocalTime aankomstTijd, String vertrek, LocalTime vertrekTijd, boolean slapen, String medicijn, boolean afwezig, String voornaam, String achternaam) {
        this.client = client;
        this.weekNummer = weekNummer;
        this.dag = dag;
        this.aankomst = aankomst;
        this.aankomstTijd = aankomstTijd;
        this.vertrek = vertrek;
        this.vertrekTijd = vertrekTijd;
        this.slapen = slapen;
        this.medicijn = medicijn;
        this.afwezig = afwezig;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public CRooster() {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getWeekNummer() {
        return weekNummer;
    }

    public void setWeekNummer(int weekNummer) {
        this.weekNummer = weekNummer;
    }

    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

    public String getAankomst() {
        return aankomst;
    }

    public void setAankomst(String aankomst) {
        this.aankomst = aankomst;
    }

    public LocalTime getAankomstTijd() {
        return aankomstTijd;
    }

    public void setAankomstTijd(LocalTime aankomstTijd) {
        this.aankomstTijd = aankomstTijd;
    }

    public String getVertrek() {
        return vertrek;
    }

    public void setVertrek(String vertrek) {
        this.vertrek = vertrek;
    }

    public LocalTime getVertrekTijd() {
        return vertrekTijd;
    }

    public void setVertrekTijd(LocalTime vertrekTijd) {
        this.vertrekTijd = vertrekTijd;
    }

    public boolean isSlapen() {
        return slapen;
    }

    public void setSlapen(boolean slapen) {
        this.slapen = slapen;
    }

    public String getMedicijn() {
        return medicijn;
    }

    public void setMedicijn(String medicijn) {
        this.medicijn = medicijn;
    }

    public boolean isAfwezig() {
        return afwezig;
    }

    public void setAfwezig(boolean afwezig) {
        this.afwezig = afwezig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CRooster cRooster = (CRooster) o;

        if (weekNummer != cRooster.weekNummer) return false;
        if (slapen != cRooster.slapen) return false;
        if (afwezig != cRooster.afwezig) return false;
        if (client != null ? !client.equals(cRooster.client) : cRooster.client != null) return false;
        if (dag != null ? !dag.equals(cRooster.dag) : cRooster.dag != null) return false;
        if (aankomst != null ? !aankomst.equals(cRooster.aankomst) : cRooster.aankomst != null) return false;
        if (aankomstTijd != null ? !aankomstTijd.equals(cRooster.aankomstTijd) : cRooster.aankomstTijd != null)
            return false;
        if (vertrek != null ? !vertrek.equals(cRooster.vertrek) : cRooster.vertrek != null) return false;
        if (vertrekTijd != null ? !vertrekTijd.equals(cRooster.vertrekTijd) : cRooster.vertrekTijd != null)
            return false;
        if (medicijn != null ? !medicijn.equals(cRooster.medicijn) : cRooster.medicijn != null) return false;
        if (voornaam != null ? !voornaam.equals(cRooster.voornaam) : cRooster.voornaam != null) return false;
        return achternaam != null ? achternaam.equals(cRooster.achternaam) : cRooster.achternaam == null;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + weekNummer;
        result = 31 * result + (dag != null ? dag.hashCode() : 0);
        result = 31 * result + (aankomst != null ? aankomst.hashCode() : 0);
        result = 31 * result + (aankomstTijd != null ? aankomstTijd.hashCode() : 0);
        result = 31 * result + (vertrek != null ? vertrek.hashCode() : 0);
        result = 31 * result + (vertrekTijd != null ? vertrekTijd.hashCode() : 0);
        result = 31 * result + (slapen ? 1 : 0);
        result = 31 * result + (medicijn != null ? medicijn.hashCode() : 0);
        result = 31 * result + (afwezig ? 1 : 0);
        result = 31 * result + (voornaam != null ? voornaam.hashCode() : 0);
        result = 31 * result + (achternaam != null ? achternaam.hashCode() : 0);
        return result;
    }
}
