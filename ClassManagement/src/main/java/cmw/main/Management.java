package cmw.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cmw.models.Position;
import cmw.utils.HibernateUtils;

public class Management {

  public static void main(String[] args) {
    Position pos = new Position("Manager"); // added Manager into DB

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
//     session.save(pos);
    session.getTransaction().commit();
    HibernateUtils.shutdown();

  }
}
