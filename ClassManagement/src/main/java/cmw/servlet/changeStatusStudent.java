package cmw.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.models.Person;

/**
 * Servlet implementation class changeStatusStudent
 */
@WebServlet("/changeStatusStudent")
public class changeStatusStudent extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public changeStatusStudent() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int idStudent = Integer.parseInt(request.getParameter("id"));
    PersonDAO personDAO = new PersonDAOImpl();
    Person person = new Person();
    person = personDAO.getPerson(idStudent);
    person.setStatus(false);
    personDAO.updatePerson(person);
    List<Person> persons = personDAO.getAllPerson();
    try {
      // get data from DB
      List<Person> listPer1 = new ArrayList<Person>();
      // get students from specific CLASS ID
      for (Person person1 : persons) {
        if (person1.getClazz() != null) {
          if (person.getClazz().getClassId() == person1.getClazz().getClassId()
              && person1.getPosition().getPositionId() == 1) {
            listPer1.add(person1);
          }
        }
      }
      String url = "/profileClass?classId=" + Integer.toString(person.getClazz().getClassId());
      request.setAttribute("listPer", listPer1);
      request.getRequestDispatcher(url).forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
