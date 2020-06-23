package cmw.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.dao.PositionDAO;
import cmw.dao.PositionDAOImpl;
import cmw.dao.SubjectDAO;
import cmw.dao.SubjectDAOImpl;
import cmw.models.Person;
import cmw.models.Position;
import cmw.models.Subject;
import cmw.utils.HibernateUtils;

public class Management {

  public static void main(String[] args) {
    // Position pos = new Position("Supervisor"); // testing1234
    PositionDAO pd = new PositionDAOImpl();
    SubjectDAO sd = new SubjectDAOImpl();
    PersonDAO personDao = new PersonDAOImpl();
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    
    List <Position> listPos = pd.getAllPosition();
    for(Position a: listPos) {
      System.out.println(a.toString());
    }
    
//    List <Person> listPerson = personDao.getAllPerson();
//    for(Person a: listPerson) {
//      System.out.println(a);
//    }
    
//    List <Subject> listSubject = sd.getAllSubject();
//    for(Subject a: listSubject) {
//      System.out.println(a);
//    }
    
    session.getTransaction().commit();
    HibernateUtils.shutdown();

  }
}
