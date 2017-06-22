package RoosterSysteem.Persistence.sql;

import RoosterSysteem.Persistence.HibernateUtil;
import RoosterSysteem.Model.cRooster.CRooster;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class CRoosterDAO extends SharedDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ArrayList<CRooster> getClientRooster() {
        ArrayList<CRooster> results = new ArrayList<CRooster>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from CRooster ").list();
        results.addAll(result);
        session.close();
        return results;
    }

}
