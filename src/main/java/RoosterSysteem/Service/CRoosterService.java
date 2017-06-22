package RoosterSysteem.Service;

import RoosterSysteem.Model.cRooster.CRooster;

import RoosterSysteem.Persistence.DAO.BaseDAO;
import RoosterSysteem.Persistence.DAO.CRoosterDAO;

import java.util.List;

/**
 * Created by slettebak on 22-Jun-17.
 */
public class CRoosterService {
    private CRoosterDAO dao = BaseDAO.getCRoosterDAO();

    public List<CRooster> getAllCRooster(){return dao.getClientRooster();}

    public void writeCRooster(CRooster c){dao.writeDAO(c);}

    public void updateCRooster(CRooster c){
        dao.updateDAO(c);
    }

    public void deleteCRooster(CRooster c){
        dao.deleteDAO(c);
    }
}

