package RoosterSysteem.Persistence.DAO;

import RoosterSysteem.Persistence.HibernateUtil;
import RoosterSysteem.Model.school.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class SchoolDAO extends SharedDAO{

    public ArrayList<School> getScholen(){
        ArrayList<School> results = new ArrayList<School>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from School ").list();
        results.addAll(result);
        session.close();
        return results;
    }
    public School getSchool(String naam){
        Session session = sessionFactory.openSession();
        School s = (School) session.createQuery("FROM School where naam=:naam")
                .setParameter("naam",naam).getSingleResult();
        session.close();
        return s;
    }

}
