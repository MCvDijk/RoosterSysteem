package RoosterSysteem.Persistence.DAO;


import org.hibernate.Session;
import RoosterSysteem.Model.persoon.Client;

import java.util.ArrayList;
import java.util.List;


public class ClientDAO extends SharedDAO {

    public  Client getClient(String voornaam,String achternaam){
        Session session = sessionFactory.openSession();
        Client c = (Client) session.createQuery("FROM Client where voornaam=:voornaam and achternaam=:achternaam")
                .setParameter("voornaam",voornaam)
                .setParameter("achternaam",achternaam).getSingleResult();
        session.close();
        return c;
    }

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
