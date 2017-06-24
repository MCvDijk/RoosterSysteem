package RoosterSysteem.Persistence.DAO;

import RoosterSysteem.Persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Silvermage on 21-6-2017.
 */
public class SharedDAO {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void writeDAO(Object o){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    public void updateDAO(Object o){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteDAO(Object o){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }
}

