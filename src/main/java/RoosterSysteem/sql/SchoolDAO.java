package RoosterSysteem.sql;

import RoosterSysteem.HibernateUtil;
import RoosterSysteem.model.persoon.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class SchoolDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ArrayList<Client> getClienten(){
        ArrayList<Client> results = new ArrayList<Client>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Client ").list();
        results.addAll(result);
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
