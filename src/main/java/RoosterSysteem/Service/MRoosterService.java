package RoosterSysteem.Service;

import RoosterSysteem.Model.mRooster.MRooster;
import RoosterSysteem.Persistence.DAO.BaseDAO;
import RoosterSysteem.Persistence.DAO.MRoosterDAO;


import java.util.List;

public class MRoosterService {
    private MRoosterDAO dao = BaseDAO.getMRoosterDAO();

    public List<MRooster> getAllMRooster(){
        return dao.getMedewerkerRooster();
    }

    public void writeMRooster(MRooster m){dao.writeDAO(m);}

    public void updateMRooster(MRooster m){
        dao.updateDAO(m);
    }

    public void deleteMRooster(MRooster m){
        dao.deleteDAO(m);
    }
}
