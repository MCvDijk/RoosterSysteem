package RoosterSysteem.Service;

import RoosterSysteem.Model.school.School;
import RoosterSysteem.Persistence.DAO.BaseDAO;
import RoosterSysteem.Persistence.DAO.SchoolDAO;

import java.util.List;

/**
 * Created by slettebak on 22-Jun-17.
 */
public class SchoolService {
    private SchoolDAO dao = BaseDAO.getSchoolDAO();

    public List<School> getAllScholen(){
        return dao.getScholen();
    }

    public School getSchool(String naam){return dao.getSchool(naam);}

    public void writeSchool(School c){dao.writeDAO(c);}

    public void updateSchool(School c){
        dao.updateDAO(c);
    }

    public void deleteSchool(School c){
        dao.deleteDAO(c);
    }
}
