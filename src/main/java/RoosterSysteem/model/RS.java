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
        deClienten = clienten.getClienten();

        MedewerkerDAO medewerkers = new MedewerkerDAO();
        deMedewerkers = medewerkers.getMedewerkers();

        CRoosterDAO clientrooster = new CRoosterDAO();
        cRoosters = clientrooster.getClientRooster();

        MRoosterDAO medewerkerrooster = new MRoosterDAO();
        mRoosters = medewerkerrooster.getMedewerkerRooster();

        SchoolDAO scholen = new SchoolDAO();
        deScholen = scholen.getScholen();



        for(MRooster mr : mRoosters){
            for(Medewerker m : deMedewerkers ){
                if(mr.getVoornaam().equals(m.getVoornaam()) && (mr.getAchternaam().equals(m.getAchternaam()))){
                    mr.setMedewerker(m);
                }
            }
        }
    }

    public ArrayList<Medewerker> getDeMedewerkers() {
        return deMedewerkers;
    }

    public ArrayList<Client> getDeClienten() {
        return deClienten;
    }

    public ArrayList<School> getDeScholen() {
        return deScholen;
    }

    public ArrayList<CRooster> getcRoosters() {
        return cRoosters;
    }

    public ArrayList<MRooster> getmRoosters() {
        return mRoosters;
    }

    public Medewerker getMedewerker(String voornaam, String achternaam){
        Medewerker resultaat = null;
        MedewerkerDAO medewerkers = new MedewerkerDAO();

        for(Medewerker m : medewerkers.getMedewerkers()){
            if(m.getVoornaam().equals(voornaam) && m.getAchternaam().equals(achternaam)){
                resultaat = m;
                break;
            }
        }
        return resultaat;
    }

    public ArrayList<MRooster> getMRoosterMedewerker(Medewerker medewerker){
        ArrayList<MRooster> mRoosters = getmRoosters();
        ArrayList<MRooster> rooster = new ArrayList<>();
        for(MRooster m : mRoosters){
            if (m.getMedewerker().equals(medewerker)){
                rooster.add(m);
            }
        }
        return rooster;
    }

}
