package RoosterSysteem.Persistence.DAO;

import RoosterSysteem.Model.persoon.Medewerker;
import RoosterSysteem.Persistence.HibernateUtil;
import RoosterSysteem.Model.mRooster.MRooster;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class MRoosterDAO extends SharedDAO {

    public ArrayList<MRooster> getAllMedewerkerRooster() {
        ArrayList<MRooster> results = new ArrayList<MRooster>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from MRooster ").list();
        results.addAll(result);
        session.close();
        return results;
    }

    public ArrayList<MRooster> getMedewerkerRooster(Medewerker m) {
        ArrayList<MRooster> results = new ArrayList<MRooster>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from MRooster where medewerker=:medewerker").setParameter("medewerker", m).list();
        results.addAll(result);
        session.close();
        return results;
    }


}

