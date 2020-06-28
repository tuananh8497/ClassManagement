package cmw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.ClassMentorDAO;
import cmw.dao.ClassMentorDAOImpl;
import cmw.dao.MentorDAO;
import cmw.dao.MentorDAOImpl;
import cmw.models.Mentor;
import cmw.models.PK_Class_Mentor;

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
		int mentorId = Integer.parseInt(request.getParameter("id"));
		ClassMentorDAO classMentorDAO = new ClassMentorDAOImpl();
		MentorDAO mentorDAO = new MentorDAOImpl();
		Mentor mentor = mentorDAO.getMentor(mentorId);
		List<PK_Class_Mentor> classMentor = classMentorDAO.getClassMentor(mentorId);
		System.out.println(mentor);
		System.out.println(classMentor);
		request.setAttribute("mentor", mentor);
		request.setAttribute("classMentor", classMentor);
		request.getRequestDispatcher("/mentor/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
