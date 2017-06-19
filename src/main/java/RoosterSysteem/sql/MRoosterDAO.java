package RoosterSysteem.sql;

import RoosterSysteem.HibernateUtil;
import RoosterSysteem.model.mRooster.MRooster;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class MRoosterDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ArrayList<MRooster> getMedewerkerRooster(){
        ArrayList<MRooster> results = new ArrayList<MRooster>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from MRooster ").list();
        results.addAll(result);
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
