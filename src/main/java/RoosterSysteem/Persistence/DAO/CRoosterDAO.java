package RoosterSysteem.Persistence.DAO;

import RoosterSysteem.Model.persoon.Client;
import RoosterSysteem.Persistence.HibernateUtil;
import RoosterSysteem.Model.cRooster.CRooster;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class CRoosterDAO extends SharedDAO {

    public ArrayList<CRooster> getClientRooster() {
        ArrayList<CRooster> results = new ArrayList<CRooster>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from CRooster ").list();
        results.addAll(result);
        session.close();
        return results;
    }

    public ArrayList<CRooster> getClientRooster(Client c) {
        ArrayList<CRooster> results = new ArrayList<CRooster>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from CRooster where client=:client").setParameter("client", c).list();
        results.addAll(result);
        session.close();
        return results;
    }

    public CRooster getClientRooster(Client c, String weeknummer,String dag){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CRooster result = (CRooster) session.createQuery("from CRooster where client=:client and weekNummer=:weeknummer and dag=:dag ")
                .setParameter("client", c)
                .setParameter("weeknummer", weeknummer)
                .setParameter("dag", dag).getSingleResult();
        session.close();
        return result;
    }

}
