package cmw.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import cmw.dao.TimetableDAO;
import cmw.dao.TimetableDAOImpl;
import cmw.dao.UserDAO;
import cmw.dao.UserDAOImpl;
import cmw.models.Class;
import cmw.models.Timetable;
import cmw.services.DateProcess;
import cmw.utils.HibernateUtils;

public class Management {

  public static void main(String[] args) {
    PositionDAO pd = new PositionDAOImpl();
    SubjectDAO sd = new SubjectDAOImpl();
    PersonDAO personDao = new PersonDAOImpl();
    ClassDAO classDAO = new ClassDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();
    UserDAO userDAO = new UserDAOImpl();
    TimetableDAO timetableDAO = new TimetableDAOImpl();
    DateProcess dp = new DateProcess();
    cmw.models.Class class1 = classDAO.getClass(1);
    // -------------------------------------------------
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    // ----------------------------------------------------
    List<Timetable> timetable = timetableDAO.getAllTimetable();
    List<Timetable> timetableReturn = new ArrayList<>();
    int courseId = 1;
    for (Timetable tkb : timetable) {
      if (tkb.getCourse().getCourseId() == courseId) {
        timetableReturn.add(tkb);
      }
    }
    LocalDate firstStartDate = class1.getExpectedStartDate();
    LocalDate startDate;
    LocalDate endDate;
//    ArrayList<LocalDate> dateStore = new ArrayList<>();
//    for (int i = 0; i < timetableReturn.size(); i++) {
//      int currentDuration = timetableReturn.get(i).getDuration();
//      if (i == 0) {
//        startDate = firstStartDate;
//        endDate = dp.addDaysSkippingWeekends(startDate, currentDuration);
//        System.out.println("#" + i + " - "+ timetableReturn.get(i).getSubject().getSubjectName() + "- START: " + startDate + " - END: "
//            + endDate);
//      } else {
//        startDate =  dateStore.get(i-1);
//        endDate = dp.addDaysSkippingWeekends(startDate, currentDuration);
//        System.out.println("#" + i + " - "+ timetableReturn.get(i).getSubject().getSubjectName() + "- START: " + startDate + " - END: "
//            + endDate);
//      }
//      dateStore.add(endDate);
//    }

    HashMap<Long, LocalDate> startDateMap = new HashMap<Long, LocalDate>();
    HashMap<Long, LocalDate> endDateMap = new HashMap<Long, LocalDate>();

    
    Long a = (long) 0;
    for (int i = 0; i < timetableReturn.size(); i++) {
      int currentDuration = timetableReturn.get(i).getDuration();
      
      if (i == 0) {
        startDate = firstStartDate;
        endDate = dp.addDaysSkippingWeekends(startDate, currentDuration);
        System.out.println("endDate: " + endDate);
        // System.out.println("#" + i + " - "+ timetableReturn.get(i).getSubject().getSubjectName()
        // + "- START: " + startDate + " - END: "
        // + endDate);
        startDateMap.put((long) i, startDate);
        endDateMap.put((long) i, endDate);
        System.out.println("startDate: " +startDateMap.get((long)i));
        System.out.println("endDate: " + endDateMap.get((long)i));
      } else {
        startDate =  endDateMap.get((long)i-1);
        System.out.println("test1" + startDate);
        System.out.println(startDate);
        endDate = dp.addDaysSkippingWeekends(startDate, currentDuration);
        System.out.println("test2" + endDate);
//        System.out.println("#" + i + " - "+ timetableReturn.get(i).getSubject().getSubjectName() + "- START: " + startDate + " - END: "
//            + endDate);
        startDateMap.put((long) i, startDate);
        endDateMap.put((long) i, endDate);
      }
    }
    
    session.getTransaction().commit();
    HibernateUtils.shutdown();

  }
}
