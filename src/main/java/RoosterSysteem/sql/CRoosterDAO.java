package RoosterSysteem.sql;

import RoosterSysteem.HibernateUtil;
import RoosterSysteem.model.cRooster.CRooster;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class CRoosterDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ArrayList<CRooster> getClientRooster() {
        ArrayList<CRooster> results = new ArrayList<CRooster>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from CRooster ").list();
        results.addAll(result);
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public void writeClientRooster(CRooster CRooster){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(CRooster);
        session.getTransaction().commit();
        session.close();
    }

    public void updateClientRooster(CRooster CRooster){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(CRooster);
        session.getTransaction().commit();
        session.close();
    }
}
