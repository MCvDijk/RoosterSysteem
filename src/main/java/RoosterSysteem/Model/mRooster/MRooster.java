package RoosterSysteem.Model.mRooster;

import RoosterSysteem.Model.persoon.Medewerker;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class MRooster implements Serializable {
    private Medewerker medewerker;
    private String weekNummer;
    private String dag;
    private LocalTime beginTijd;
    private LocalTime eindTijd;
    private LocalTime pauze;
    private boolean ziek;
    private String voornaam;
    private String achternaam;
    private boolean vast;

    public MRooster() {
    }

    public MRooster(Medewerker medewerker, String weekNummer, String dag, LocalTime beginTijd, LocalTime eindTijd, LocalTime pauze, boolean ziek, String voornaam, String achternaam, boolean vast) {
        this.medewerker = medewerker;
        this.weekNummer = weekNummer;
        this.dag = dag;
        this.beginTijd = beginTijd;
        this.eindTijd = eindTijd;
        this.pauze = pauze;
        this.ziek = ziek;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.vast = vast;
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

    public String getWeekNummer() {
        return weekNummer;
    }

    public void setWeekNummer(String weekNummer) {
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

    public boolean isVast() {
        return vast;
    }

    public void setVast(boolean vast) {
        this.vast = vast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MRooster mRooster = (MRooster) o;

        if (ziek != mRooster.ziek) return false;
        if (vast != mRooster.vast) return false;
        if (medewerker != null ? !medewerker.equals(mRooster.medewerker) : mRooster.medewerker != null) return false;
        if (weekNummer != null ? !weekNummer.equals(mRooster.weekNummer) : mRooster.weekNummer != null) return false;
        if (dag != null ? !dag.equals(mRooster.dag) : mRooster.dag != null) return false;
        if (beginTijd != null ? !beginTijd.equals(mRooster.beginTijd) : mRooster.beginTijd != null) return false;
        if (eindTijd != null ? !eindTijd.equals(mRooster.eindTijd) : mRooster.eindTijd != null) return false;
        if (pauze != null ? !pauze.equals(mRooster.pauze) : mRooster.pauze != null) return false;
        if (voornaam != null ? !voornaam.equals(mRooster.voornaam) : mRooster.voornaam != null) return false;
        return achternaam != null ? achternaam.equals(mRooster.achternaam) : mRooster.achternaam == null;
    }

    @Override
    public int hashCode() {
        int result = medewerker != null ? medewerker.hashCode() : 0;
        result = 31 * result + (weekNummer != null ? weekNummer.hashCode() : 0);
        result = 31 * result + (dag != null ? dag.hashCode() : 0);
        result = 31 * result + (beginTijd != null ? beginTijd.hashCode() : 0);
        result = 31 * result + (eindTijd != null ? eindTijd.hashCode() : 0);
        result = 31 * result + (pauze != null ? pauze.hashCode() : 0);
        result = 31 * result + (ziek ? 1 : 0);
        result = 31 * result + (voornaam != null ? voornaam.hashCode() : 0);
        result = 31 * result + (achternaam != null ? achternaam.hashCode() : 0);
        result = 31 * result + (vast ? 1 : 0);
        return result;
    }
}
