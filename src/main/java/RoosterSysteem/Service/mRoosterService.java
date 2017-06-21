package RoosterSysteem.Service;

import RoosterSysteem.Model.mRooster.MRooster;
import RoosterSysteem.Persistence.sql.BaseDAO;
import RoosterSysteem.Persistence.sql.MRoosterDAO;


import java.util.List;

public class mRoosterService {
    private MRoosterDAO dao = BaseDAO.getMRoosterDAO();

    public List<MRooster> getAllMRooster(){
        return dao.getMedewerkerRooster();
    }

    public void writeMRooster(MRooster m){dao.WriteDAO(m);}

    public void updateVereniging(MRooster m){
        dao.updateEntity(v);
    }

    public void deleteVereniging(MRooster m){
        dao.deleteEntity(v);
    }
}
