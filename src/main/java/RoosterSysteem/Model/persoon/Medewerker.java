package RoosterSysteem.Model.persoon;

import RoosterSysteem.Model.mRooster.MRooster;

import java.io.Serializable;
import java.util.ArrayList;


public class Medewerker extends Persoon implements Serializable {
    private ArrayList<MRooster> mRoosters;
    public Medewerker() {
    }

    public Medewerker(String voornaam, String achternaam, String adres, String plaats, String email, int telefoonNummer) {
        super(voornaam, achternaam, adres, plaats, email, telefoonNummer);
    }

    public ArrayList<MRooster> getmRoosters() {
        return mRoosters;
    }

    public void setmRoosters(ArrayList<MRooster> mRoosters) {
        this.mRoosters = mRoosters;
    }
}
