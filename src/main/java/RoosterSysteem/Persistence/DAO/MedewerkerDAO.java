package RoosterSysteem.Persistence.DAO;

import RoosterSysteem.Persistence.HibernateUtil;
import RoosterSysteem.Model.persoon.Medewerker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class MedewerkerDAO extends SharedDAO {


    public  Medewerker getMedewerker(String voornaam,String achternaam){
        Session session = sessionFactory.openSession();
        Medewerker m = (Medewerker) session.createQuery("FROM Medewerker where voornaam=:voornaam and achternaam=:achternaam")
                .setParameter("voornaam",voornaam)
                .setParameter("achternaam",achternaam).getSingleResult();
        session.close();
        return m;
    }

    public ArrayList<Medewerker> getMedewerkers(){
        ArrayList<Medewerker> results = new ArrayList<Medewerker>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Medewerker ").list();
        results.addAll(result);
        session.close();
        return results;
    }
}
