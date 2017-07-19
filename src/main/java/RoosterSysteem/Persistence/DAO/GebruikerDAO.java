package RoosterSysteem.Persistence.DAO;

import RoosterSysteem.Model.gebruiker.Gebruiker;
import RoosterSysteem.Model.persoon.Client;
import RoosterSysteem.Persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class GebruikerDAO extends SharedDAO {

    public Gebruiker getGebruiker(String gebruikersnaam, String password){
        String role = null;
        Session session = sessionFactory.openSession();
        Gebruiker g = (Gebruiker) session.createQuery("FROM Gebruiker where gebruikersnaam=:gebruikersnaam and wachtwoord=:password")
                .setParameter("gebruikersnaam",gebruikersnaam)
                .setParameter("password",password).getSingleResult();
        session.close();
        return g;
    }
}

