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
import cmw.models.Class;

/**
 * Servlet implementation class showclass
 */
@WebServlet("/showClass")
public class showClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDAO classDao = new ClassDAOImpl();
		try {
			// get data from DB
			List<Class> listClass = classDao.getAllClass();
			// chuyen den view
			request.setAttribute("listClass", listClass);
			request.getRequestDispatcher("/class/showClasses.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
		}

}
