package cmw.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.CourseDAO;
import cmw.dao.CourseDAOImpl;
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.models.Class;
import cmw.models.Course;
import cmw.models.Person;
import cmw.utils.DateUtils;

/**
 * Servlet implementation class addClass
 */
@WebServlet("/addClass")
public class addClass extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public addClass() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // response.sendRedirect("/ClassManagement/class/addClass.jsp");
    CourseDAO courseDao = new CourseDAOImpl();
    try {
      List<Course> listCourse = courseDao.getAllCourse();
      request.setAttribute("listCourse", listCourse);
      request.getRequestDispatcher("/class/addClass.jsp").forward(request, response);
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
       request.getRequestDispatcher("/showClass").forward(request, response);
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
    ClassDAO classDAO = new ClassDAOImpl();
    Class clazz = new Class();
    Course course = new Course();
    CourseDAO courseDAO = new CourseDAOImpl();

    String classCode = request.getParameter("classCode");
    String expectStartDate = request.getParameter("expectedStartDate");
    int courseId = Integer.parseInt(request.getParameter("courseId"));
    course = courseDAO.getCourse(courseId);
    LocalDate expectedStartDate = LocalDate.parse(expectStartDate);

    clazz.setClassCode(classCode);
    clazz.setCourse(course);
    clazz.setExpectedStartDate(expectedStartDate);

    classDAO.saveClass(clazz);
  }
}
