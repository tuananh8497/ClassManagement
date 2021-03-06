package cmw.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import cmw.models.Class;
import cmw.models.Course;
import cmw.utils.DateUtils;

/**
 * Servlet implementation class aditClass
 */
@WebServlet("/editClass")
public class editClass extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public editClass() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      getClassInfo(request, response);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      editClassInfo(request, response);
      request.getRequestDispatcher("/showClass").forward(request, response);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  protected void getClassInfo(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ClassDAO classDao = new ClassDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();
    int classId = Integer.parseInt(request.getParameter("classId"));
    try {
      Class class1 = classDao.getClass(classId);
      request.setAttribute("class1", class1);
      List<Course> listCourse = courseDAO.getAllCourse();
      request.setAttribute("listCourse", listCourse);
      // request.getRequestDispatcher("/class/editClass.jsp").forward(request, response);
      request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void editClassInfo(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException, ParseException {
    ClassDAO classDAO = new ClassDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();
    Class clazz = new Class();
    Course course = new Course();

    int classId = Integer.parseInt(request.getParameter("idClass"));
    String classCode = request.getParameter("classCode");
    String adminAccount = request.getParameter("adminAccount");
    String expectStartDate = request.getParameter("expectedStartDate");
    String expectEndDate = request.getParameter("expectedEndDate");
    String actStartDate = request.getParameter("actualStartDate");
    String actEndDate = request.getParameter("actualEndDate");
    int courseId = Integer.parseInt(request.getParameter("courseId"));
    String status = request.getParameter("status");

    System.out.println(expectStartDate);
    System.out.println(expectEndDate);
    System.out.println(actStartDate);
    System.out.println(actEndDate);
    System.out.println(status);
  
    
    course = courseDAO.getCourse(courseId);
    clazz.setClassId(classId);
    clazz.setClassCode(classCode);
    clazz.setAdminAccount(adminAccount);
    clazz.setCourse(course);
    clazz.setStatus(Boolean.parseBoolean(status));

     if (expectStartDate != null) {
     LocalDate expectedStartDate = LocalDate.parse(expectStartDate);
     clazz.setExpectedStartDate(expectedStartDate);
     System.out.println(expectedStartDate);
     }
     if (expectEndDate != null) {
     LocalDate expectedEndDate = LocalDate.parse(expectEndDate);
     clazz.setExpectedEndDate(expectedEndDate);
     System.out.println(expectedEndDate);
     }
     if (actStartDate != null) {
     LocalDate actualStartDate = LocalDate.parse(actStartDate);
     clazz.setActualStartDate(actualStartDate);
     System.out.println(actualStartDate);
     }
     if (actEndDate != null) {
     LocalDate actualEndDate = LocalDate.parse(actEndDate);
     clazz.setactualEndDate(actualEndDate);
     System.out.println(actualEndDate);
     }

    classDAO.updateClass(clazz);;

  }
}
