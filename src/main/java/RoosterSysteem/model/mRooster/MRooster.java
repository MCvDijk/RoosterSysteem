package RoosterSysteem.model.mRooster;

import RoosterSysteem.model.persoon.Medewerker;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class MRooster {
    private Medewerker medewerker;
    private int weekNummer;
    private String dag;
    private LocalTime beginTijd;
    private LocalTime eindTijd;
    private LocalTime pauze;
    private boolean ziek;
    private String voornaam;
    private String achternaam;

    public MRooster(Medewerker medewerker, int weekNummer, String dag, LocalTime beginTijd, LocalTime eindTijd, LocalTime pauze, boolean ziek, String voornaam, String achternaam) {
        this.medewerker = medewerker;
        this.weekNummer = weekNummer;
        this.dag = dag;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.pauze = pauze;
        this.ziek = ziek;
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

    public Medewerker getMedewerker() {
        return medewerker;
    }

    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
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

    public LocalTime getBeginTijd() {
        return beginTijd;
    }

    public void setBeginTijd(LocalTime beginTijd) {
        this.beginTijd = beginTijd;
    }

    public LocalTime getEindTijd() {
        return eindTijd;
    }

    public void setEindTijd(LocalTime eindTijd) {
        this.eindTijd = eindTijd;
    }

    public LocalTime getPauze() {
        return pauze;
    }

    public void setPauze(LocalTime pauze) {
        this.pauze = pauze;
    }

    public boolean isZiek() {
        return ziek;
    }

    public void setZiek(boolean ziek) {
        this.ziek = ziek;
    }
}
