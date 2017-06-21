package RoosterSysteem.sql;

import RoosterSysteem.HibernateUtil;
import RoosterSysteem.model.persoon.Medewerker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class MedewerkerDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ArrayList<Medewerker> getMedewerkers(){
        ArrayList<Medewerker> results = new ArrayList<Medewerker>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Medewerker ").list();
        results.addAll(result);
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
