package cmw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.MentorDAO;
import cmw.dao.MentorDAOImpl;
import cmw.models.Mentor;

/**
 * Servlet implementation class profileMentor
 */
@WebServlet("/profile-mentor")
public class profileMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileMentor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mentorAccount = request.getParameter("account");
		MentorDAO mentorDAO = new MentorDAOImpl();
		Mentor mentor = mentorDAO.getMentor(mentorAccount);
		System.out.println(mentor);
		request.setAttribute("mentor", mentor);
		request.getRequestDispatcher("/mentor/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
