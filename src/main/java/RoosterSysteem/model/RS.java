package RoosterSysteem.model;


import RoosterSysteem.model.cRooster.CRooster;
import RoosterSysteem.model.mRooster.MRooster;
import RoosterSysteem.model.persoon.Client;
import RoosterSysteem.model.persoon.Medewerker;
import RoosterSysteem.model.school.School;
import RoosterSysteem.sql.*;

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

    private RS(){
        deClienten = new ArrayList<Client>();
        deMedewerkers = new ArrayList<Medewerker>();
        deScholen = new ArrayList<School>();
        cRoosters = new ArrayList<CRooster>();
        mRoosters = new ArrayList<MRooster>();

        ClientDAO clienten = new ClientDAO();
        MedewerkerDAO medewerkers = new MedewerkerDAO();
        CRoosterDAO clientrooster = new CRoosterDAO();
        MRoosterDAO medewerkerrooster = new MRoosterDAO();
        SchoolDAO scholen = new SchoolDAO();

        deClienten = clienten.getClienten();

    }


}
