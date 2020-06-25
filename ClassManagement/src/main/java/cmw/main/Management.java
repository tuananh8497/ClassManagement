package cmw.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.dao.PositionDAO;
import cmw.dao.PositionDAOImpl;
import cmw.dao.SubjectDAO;
import cmw.dao.SubjectDAOImpl;
import cmw.models.Class;
import cmw.models.Position;
import cmw.utils.HibernateUtils;

public class Management {

  public static void main(String[] args) {
    PositionDAO pd = new PositionDAOImpl();
    SubjectDAO sd = new SubjectDAOImpl();
    PersonDAO personDao = new PersonDAOImpl();
    ClassDAO classDAO = new ClassDAOImpl();
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    session.getTransaction().commit();
    HibernateUtils.shutdown();

  }
}