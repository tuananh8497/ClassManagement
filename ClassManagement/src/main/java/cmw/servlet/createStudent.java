package cmw.servlet;

import java.io.IOException;
import java.time.LocalDate;
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
import cmw.dao.PositionDAO;
import cmw.dao.PositionDAOImpl;
import cmw.models.Class;
import cmw.models.Person;
import cmw.models.Position;
import cmw.services.studentServices;

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
		try {
			ClassDAO classDAO = new ClassDAOImpl();
			
			// Lấy list class
			studentServices services = new studentServices();
			List<String> listClassCode = services.getAllClassCode();
			request.setAttribute("listClassCode", listClassCode);
			request.getRequestDispatcher("/student/createStudent.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			ClassDAO classDAO = new ClassDAOImpl();

			// Lấy data từ form
			String account = request.getParameter("account");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String stringDateOfBirth = request.getParameter("dateOfBirth");
			LocalDate dateOfBirth = LocalDate.parse(stringDateOfBirth);
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String school = request.getParameter("school");
			String citizenId = request.getParameter("citizenId");
			String bankAccount = request.getParameter("bankAccount");
			String classCode = request.getParameter("classCode");
			String strStatus = request.getParameter("status");
			boolean status = (strStatus.equals("active"));
			
			// Lấy danh sách tất cả các Class có trong DB
			List<Class> listClass = classDAO.getAllClass();

			// Lấy ra Class có classCode giống như form edit.
			Class clazz = null;
			for (Class clazz1 : listClass) {
				if (clazz1.getClassCode().equals(classCode)) {
					clazz = clazz1;
					break;
				}
			}
			System.out.println(clazz.getClassCode());

			Position position = positionDAO.getPosition(1);
			Person person = new Person(account, name, bankAccount, email, phone, citizenId, address, dateOfBirth,
					school, status, position, clazz);

			personDAO.savePerson(person);
			request.setAttribute("mess", "Done");
			request.getRequestDispatcher("/student/createStudent.jsp").forward(request, response);
		} catch (Exception e) {

		}
	}

}
