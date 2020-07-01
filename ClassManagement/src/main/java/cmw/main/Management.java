package cmw.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.CourseDAO;
import cmw.dao.CourseDAOImpl;
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.dao.PositionDAO;
import cmw.dao.PositionDAOImpl;
import cmw.dao.SubjectDAO;
import cmw.dao.SubjectDAOImpl;
import cmw.dao.UserDAO;
import cmw.dao.UserDAOImpl;
import cmw.utils.HibernateUtils;

public class Management {

  public static void main(String[] args) {
    PositionDAO pd = new PositionDAOImpl();
    SubjectDAO sd = new SubjectDAOImpl();
    PersonDAO personDao = new PersonDAOImpl();
    ClassDAO classDAO = new ClassDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();
    UserDAO userDAO = new UserDAOImpl();
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    // Position pos = new Position("Manager");
    // pd.savePosition(pos);
    // Date d1 = DateUtils.formatDate("2020-07-30");
    // Course course = new Course();
    // course = courseDAO.getCourse(1);
    // Class clazz = new Class("HN20_CPL_Java_05", course, d1);
    // classDAO.updateClass(clazz);
    
    session.getTransaction().commit();
    HibernateUtils.shutdown();

  }
}
