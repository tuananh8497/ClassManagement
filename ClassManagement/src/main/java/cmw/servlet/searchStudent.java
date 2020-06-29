package cmw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.models.Person;
import cmw.services.studentServices;

/**
 * Servlet implementation class searchStudent
 */
@WebServlet("/search-student")
public class searchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDAO personDAO = new PersonDAOImpl();
		try {
			studentServices services = new studentServices();
			// get data from DB
			List<Person> listPerson = personDAO.getAllPerson();
			List<Person> listStudent = services.showStudents(listPerson);
			System.out.println("listStudent: " + listStudent);

			// Lấy dữ liệu đầu vào của search
			int searchBy = Integer.parseInt(request.getParameter("searchBy"));
			String searchString = request.getParameter("searchString");

			
			List<Person> listStudentReturn = null;
			switch (searchBy) {
			case 1:
				listStudentReturn = services.searchByAccount(searchString, listStudent);
				request.setAttribute("listStudent", listStudentReturn);
				request.getRequestDispatcher("/student/showStudents.jsp").forward(request, response);
				break;
			case 2:
				listStudentReturn = services.searchByName(searchString, listStudent);
				request.setAttribute("listStudent", listStudentReturn);
				request.getRequestDispatcher("/student/showStudents.jsp").forward(request, response);
				break;
			case 3:
				listStudentReturn = services.searchByClass(searchString, listStudent);
				request.setAttribute("listStudent", listStudentReturn);
				request.getRequestDispatcher("/student/showStudents.jsp").forward(request, response);
				System.out.println("Da chay het searchby class");
				break;
			}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
