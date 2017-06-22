package RoosterSysteem.Persistence.DAO;

import RoosterSysteem.Persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import RoosterSysteem.Model.persoon.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class ClientDAO extends SharedDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ArrayList<Client> getClienten(){
        ArrayList<Client> results = new ArrayList<Client>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Client ").list();
        results.addAll(result);
        session.close();
        return results;
    }


}
