package cmw.servlet;

import java.io.IOException;
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
import cmw.models.Subject;
import cmw.models.Timetable;

/**
 * Servlet implementation class showTimetable
 */
@WebServlet("/showTimetable")
public class showTimetable extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public showTimetable() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    // response.getWriter().append("Served at: ").append(request.getContextPath());
    TimetableDAO timetableDao = new TimetableDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();
    SubjectDAO subjectDAO = new SubjectDAOImpl();
    
    try {
      List<Timetable> listTimetable = timetableDao.getAllTimetable();
      List<Course> listCourse = courseDAO.getAllCourse();
      List<Subject> listSubject = subjectDAO.getAllSubject();

      request.setAttribute("listTimetable", listTimetable);
      request.setAttribute("listCourse", listCourse);
      request.setAttribute("listSubject", listSubject);
      request.getRequestDispatcher("/timetable/showTimetable.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
