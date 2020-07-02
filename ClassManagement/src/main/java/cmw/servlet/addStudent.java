package cmw.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.models.Class;
import cmw.models.Course;
import cmw.models.Person;
import cmw.services.studentServices;

/**
 * Servlet implementation class addStudent
 */
@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public addStudent() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int classId = Integer.parseInt(request.getParameter("classId"));
    PersonDAO personDAO = new PersonDAOImpl();
    ClassDAO classDao = new ClassDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();

    try {
      // get data from DB
      List<Person> listPer1 = new ArrayList<Person>();
      List<Person> listPer2 = new ArrayList<Person>();

      List<Person> persons = personDAO.getAllPerson();
      List<Course> listCourse = courseDAO.getAllCourse();

      // get students from specific CLASS ID
      for (Person person : persons) {
        if (classId == person.getClazz().getClassId()
            && person.getPosition().getPositionId() == 1) {
          listPer1.add(person);
          // System.out.println(listPer);
        }
      }

      // get all students
      for (Person student : persons) {
        if (student.getPosition().getPositionId() == 1) {
          listPer2.add(student);
        }
      }

      studentServices services = new studentServices();
      List<Person> listStudent = services.showStudents(listPer2);

      Class class1 = classDao.getClass(classId);
      request.setAttribute("class1", class1);
      request.setAttribute("listPer", listPer1);
      request.setAttribute("listCourse", listCourse);
      request.setAttribute("listStudent", listStudent);
      request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    searchStudent(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    addStudentToClass(request, response);
  }

  protected void searchStudent(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PersonDAO personDAO = new PersonDAOImpl();
    try {
      studentServices services = new studentServices();
      List<Person> listPerson = personDAO.getAllPerson();
      List<Person> listStudent = services.showStudents(listPerson);

      // Lấy dữ liệu đầu vào của search
      int searchBy = Integer.parseInt(request.getParameter("searchBy"));
      String searchString = request.getParameter("searchString");


      List<Person> listStudentReturn = null;
      switch (searchBy) {
        case 1:
          listStudentReturn = services.searchByAccount(searchString, listStudent);
          request.setAttribute("listStudent", listStudentReturn);
          request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
          break;
        case 2:
          listStudentReturn = services.searchByName(searchString, listStudent);
          request.setAttribute("listStudent", listStudentReturn);
          request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
          break;
        case 3:
          listStudentReturn = services.searchByClass(searchString, listStudent);
          request.setAttribute("listStudent", listStudentReturn);
          request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
          System.out.println("Da chay het searchby class");
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void getProfile(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int classId = Integer.parseInt(request.getParameter("classId"));
    PersonDAO personDAO = new PersonDAOImpl();
    ClassDAO classDao = new ClassDAOImpl();
    CourseDAO courseDAO = new CourseDAOImpl();

    // System.out.println(classId);
    try {
      // get data from DB
      List<Person> listPer1 = new ArrayList<Person>();
      List<Person> listPer2 = new ArrayList<Person>();

      List<Person> persons = personDAO.getAllPerson();
      List<Course> listCourse = courseDAO.getAllCourse();

      // get students from specific CLASS ID
      for (Person person : persons) {
        if (classId == person.getClazz().getClassId()
            && person.getPosition().getPositionId() == 1) {
          listPer1.add(person);
          // System.out.println(listPer);
        }
      }

      // get all students
      for (Person student : persons) {
        if (student.getPosition().getPositionId() == 1) {
          listPer2.add(student);
        }
      }

      studentServices services = new studentServices();
      List<Person> listStudent = services.showStudents(listPer2);

      Class class1 = classDao.getClass(classId);
      request.setAttribute("class1", class1);
      request.setAttribute("listPer", listPer1);
      request.setAttribute("listCourse", listCourse);
      request.setAttribute("listStudent", listStudent);
      request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void addStudentToClass(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PersonDAO personDAO = new PersonDAOImpl();
    ClassDAO classDAO = new ClassDAOImpl();
    int studentId = Integer.parseInt(request.getParameter("checkBoxStudentId"));
    Person student = personDAO.getPerson(studentId);
    String classCode = request.getParameter("classCode");

    String strCheckBoxValue = request.getParameter("checkbox");
    boolean checkBox =false;
    if (strCheckBoxValue != null) {
      checkBox = true;
    }
    
    System.out.println("Student Id result: " + studentId);
    System.out.println("class Code result: " + classCode);
    List<Class> listClass = classDAO.getAllClass();
    Class clazz = null;
    for (Class clazz1 : listClass) {
      if (clazz1.getClassCode().equals(classCode)) {
        clazz = clazz1;
        break;
      }
    }

    
    student.setClazz(clazz);
    personDAO.updatePerson(student);
    System.out.println(clazz);
    System.out.println(student);
    request.getRequestDispatcher("/home.jsp").forward(request, response);
  }
}
