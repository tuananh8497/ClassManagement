package cmw.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
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
import cmw.models.Class;
import cmw.models.Course;
import cmw.models.Subject;

/**
 * Servlet implementation class createCourseSubject
 */
@WebServlet("/createCourseSubject")
public class createCourseSubject extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public createCourseSubject() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
     response.sendRedirect("/ClassManagement/timetable/createCourseSubject.jsp");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      create(request, response);
    } catch (IOException | ServletException | ParseException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("null")
  private void create(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException, ParseException {

    Course course = new Course();
    CourseDAO courseDAO = new CourseDAOImpl();
    Subject subject = new Subject();
    SubjectDAO subjectDAO = new SubjectDAOImpl();

    String courseName = request.getParameter("courseName");
    String subjectName = request.getParameter("subjectName");

    try {
      
      if(courseName != null && !courseName.isEmpty()) {
        course.setCourseName(courseName);
        course.setCourseName(courseName);
        courseDAO.saveCourse(course);
      }
      
      if(subjectName != null && !subjectName.isEmpty()){
        subject.setSubjectName(subjectName);
        subject.setSubjectName(subjectName);
        subjectDAO.saveSubject(subject);
      }
      
      request.getRequestDispatcher("/showTimetable").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
