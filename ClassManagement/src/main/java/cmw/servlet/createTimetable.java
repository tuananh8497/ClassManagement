package cmw.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.CourseDAO;
import cmw.dao.CourseDAOImpl;
import cmw.dao.SubjectDAO;
import cmw.dao.SubjectDAOImpl;
import cmw.dao.TimetableDAO;
import cmw.dao.TimetableDAOImpl;
import cmw.models.Class;
import cmw.models.Course;
import cmw.models.PK_Timetable;
import cmw.models.Subject;
import cmw.models.Timetable;

/**
 * Servlet implementation class createTimetable
 */
@WebServlet("/createTimetable")
public class createTimetable extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public createTimetable() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    CourseDAO courseDAO = new CourseDAOImpl();
    SubjectDAO subjectDAO = new SubjectDAOImpl();
    try {
      List<Course> listCourse = courseDAO.getAllCourse();
      List<Subject> listSubject = subjectDAO.getAllSubject();
      request.setAttribute("listCourse", listCourse);
      request.setAttribute("listSubject", listSubject);

      request.getRequestDispatcher("/timetable/createTimetable.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      create(request, response);
      request.getRequestDispatcher("/showTimetable").forward(request, response);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private void create(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException, ParseException {
    Timetable timetable = new Timetable();
    TimetableDAO timetableDAO = new TimetableDAOImpl();
    Course course = new Course();
    CourseDAO courseDAO = new CourseDAOImpl();
    Subject subject = new Subject();
    SubjectDAO subjectDAO = new SubjectDAOImpl();
    PK_Timetable pk_Timetable = new PK_Timetable();

    int courseId = Integer.parseInt(request.getParameter("courseId"));
    int subjectId = Integer.parseInt(request.getParameter("subjectId"));
    int priority = Integer.parseInt(request.getParameter("priority"));
    int duration = Integer.parseInt(request.getParameter("duration"));
    
    course = courseDAO.getCourse(courseId);
    subject = subjectDAO.getSubject(subjectId);
    
    pk_Timetable.setCourseId(courseId);
    pk_Timetable.setSubjectId(subjectId);
    
    timetable.setPk(pk_Timetable);
    timetable.setPriority(priority);
    timetable.setDuration(duration);

    timetableDAO.updateTimetable(timetable);
  }
}
