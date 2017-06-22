package RoosterSysteem.Service;

import RoosterSysteem.Model.mRooster.MRooster;
import RoosterSysteem.Model.school.School;
import RoosterSysteem.Persistence.sql.BaseDAO;
import RoosterSysteem.Persistence.sql.MRoosterDAO;
import RoosterSysteem.Persistence.sql.SchoolDAO;

import java.util.List;

/**
 * Created by slettebak on 22-Jun-17.
 */
public class SchoolService {
    private SchoolDAO dao = BaseDAO.getSchoolDAO();

    public List<School> getAllScholen(){
        return dao.getScholen();
    }

    public void writeSchool(School c){dao.writeDAO(c);}

    public void updateSchool(School c){
        dao.updateDAO(c);
    }

    public void deleteSchool(School c){
        dao.deleteDAO(c);
    }
}
