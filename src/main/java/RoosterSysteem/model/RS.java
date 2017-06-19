package RoosterSysteem.model;


import RoosterSysteem.model.cRooster.CRooster;
import RoosterSysteem.model.mRooster.MRooster;
import RoosterSysteem.model.persoon.Client;
import RoosterSysteem.model.persoon.Medewerker;
import RoosterSysteem.model.school.School;

import java.util.ArrayList;

public class RS {
    private static RS myRS = new RS();

    public static RS getInstance() {
        return myRS;
    }

    private ArrayList<Client> deClienten;
    private ArrayList<Medewerker> deMedewerkers;
    private ArrayList<School> deScholen;
    private ArrayList<CRooster> cRoosters;
    private ArrayList<MRooster> mRoosters;


}
