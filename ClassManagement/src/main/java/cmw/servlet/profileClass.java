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
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.models.Class;
import cmw.models.Person;

/**
 * Servlet implementation class profileClass
 */
@WebServlet("/profileClass")
public class profileClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classId = Integer.parseInt(request.getParameter("classId"));
		PersonDAO personDAO = new PersonDAOImpl();
		ClassDAO classDao = new ClassDAOImpl();
		System.out.println(classId);
		try {
			// get data from DB
			List<Person> listPer = new ArrayList<Person>();
			List<Person> persons = personDAO.getAllPerson();
		    for(Person person: persons) {
		        if(classId == person.getClazz().getClassId() && person.getPosition().getPositionId() == 1) {
		        	listPer.add(person);
		        	System.out.println(listPer);
		        }
		      }
			// chuyen den view
		    Class class1 = classDao.getClass(classId);
		    request.setAttribute("class1", class1);
			request.setAttribute("listPer", listPer);
			request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
