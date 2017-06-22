package RoosterSysteem.Service;

import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Persistence.DAO.BaseDAO;
import RoosterSysteem.Persistence.DAO.MedewerkerDAO;

import java.util.List;

/**
 * Created by slettebak on 22-Jun-17.
 */
public class MedewerkerService {
    private MedewerkerDAO dao = BaseDAO.getMedewerkerDAO();

    public Medewerker getMedewerker(String voornaam,String achternaam){return dao.getMedewerker(voornaam,achternaam);}

    public List<Medewerker> getAllMedewerkers (){return dao.getMedewerkers();}

    public void writeMedewerker (Medewerker m){dao.writeDAO(m);}

    public void updateMedewerker(Medewerker m){
        dao.updateDAO(m);
    }

    public void deleteMedewerker(Medewerker m){
        dao.deleteDAO(m);
    }
}

