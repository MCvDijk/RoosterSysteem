package RoosterSysteem.model.cRooster;

import RoosterSysteem.model.persoon.Client;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class CRooster {
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
}
