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
import cmw.dao.MentorDAO;
import cmw.dao.MentorDAOImpl;
import cmw.models.Class;
import cmw.models.Mentor;

/**
 * Servlet implementation class showMentor
 */
@WebServlet("/showMentor")
public class showMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showMentor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MentorDAO mentorDao = new MentorDAOImpl();
		try {

			List<Mentor> listMentor = mentorDao.getAllMentor();
			request.setAttribute("listMentor", listMentor);
//			request.setAttribute("message", "Welcome!!!");
			request.getRequestDispatcher("/mentor/showMentor.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
