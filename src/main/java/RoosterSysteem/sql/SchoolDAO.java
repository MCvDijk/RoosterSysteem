package RoosterSysteem.sql;

import RoosterSysteem.HibernateUtil;
import RoosterSysteem.model.school.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slettebak on 19-Jun-17.
 */
public class SchoolDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ArrayList<School> getScholen(){
        ArrayList<School> results = new ArrayList<School>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from School ").list();
        results.addAll(result);
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
