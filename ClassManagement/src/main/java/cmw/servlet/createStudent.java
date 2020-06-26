package cmw.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.dao.PositionDAO;
import cmw.dao.PositionDAOImpl;
import cmw.models.Person;
import cmw.models.Position;
import cmw.utils.DateUtils;

/**
 * Servlet implementation class createStudent
 */
@WebServlet("/createStudent")
public class createStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ClassManagement/student/createStudent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PositionDAO positionDAO = new PositionDAOImpl();
			PersonDAO personDAO = new PersonDAOImpl();
			
			// Lấy data từ form
			String account = request.getParameter("account");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String stringDateOfBirth = request.getParameter("dateOfBirth");
			System.out.println(stringDateOfBirth);
			Date dateOfBirth = DateUtils.formatDate(stringDateOfBirth);
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String school = request.getParameter("school");
			String citizenId = request.getParameter("citizenId");
			String bankAccount = request.getParameter("bankAccount");
			
			Position position = positionDAO.getPosition(1);
			Person person = new Person(account, name, bankAccount, email, phone, citizenId, address, dateOfBirth, school, false, position);
			
			personDAO.savePerson(person);
			request.setAttribute("mess", "Done");
			request.getRequestDispatcher("/student/createStudent.jsp").forward(request, response);
		} catch (Exception e) {

		}
	}

}
