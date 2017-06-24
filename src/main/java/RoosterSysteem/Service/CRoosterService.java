package RoosterSysteem.Service;

import RoosterSysteem.Model.cRooster.CRooster;

import RoosterSysteem.Model.persoon.Client;
import RoosterSysteem.Persistence.DAO.BaseDAO;
import RoosterSysteem.Persistence.DAO.CRoosterDAO;

import java.util.List;


public class CRoosterService {
    private CRoosterDAO dao = BaseDAO.getCRoosterDAO();

    public List<CRooster> getAllCRooster(){return dao.getClientRooster();}

    public List<CRooster> getClientRooster(Client c){return dao.getClientRooster(c);}

    public void writeCRooster(CRooster c){dao.writeDAO(c);}

    public void updateCRooster(CRooster c){
        dao.updateDAO(c);
    }

    public void deleteCRooster(CRooster c){
        dao.deleteDAO(c);
    }
}

