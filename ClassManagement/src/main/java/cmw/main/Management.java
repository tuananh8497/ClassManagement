package cmw.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.dao.PositionDAO;
import cmw.dao.PositionDAOImpl;
import cmw.models.Position;
import cmw.utils.HibernateUtils;

public class Management {

  public static void main(String[] args) {
    // Position pos = new Position("Supervisor"); // testing1234
    PositionDAO pd = new PositionDAOImpl();
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    // session.save(pos);
    System.out.println(pd.getPosition(1));
    session.getTransaction().commit();
    HibernateUtils.shutdown();

  }
}
