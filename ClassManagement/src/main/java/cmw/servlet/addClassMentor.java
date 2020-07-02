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
import cmw.dao.ClassMentorDAO;
import cmw.dao.ClassMentorDAOImpl;
import cmw.dao.MentorDAO;
import cmw.dao.MentorDAOImpl;
import cmw.models.Class_Mentor;
import cmw.models.Mentor;
import cmw.models.PK_Class_Mentor;
import cmw.models.Class;

/**
 * Servlet implementation class addClassMentor
 */
@WebServlet("/addClassMentor")
public class addClassMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addClassMentor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ClassManagement/mentor/profile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ClassMentorDAO classMentorDAO = new ClassMentorDAOImpl();
			ClassDAO classDAO = new ClassDAOImpl();
			MentorDAO mentorDAO = new MentorDAOImpl();
	
			String classCode = request.getParameter("classCode");
			List<Class> clazz = classDAO.getClass(classCode);
			System.out.println(clazz);
			int classId = clazz.get(0).getClassId();
			int mentorId = Integer.parseInt(request.getParameter("mentorId"));
			
			PK_Class_Mentor pkClassMentor1 = new PK_Class_Mentor(classId, mentorId);
			Class_Mentor classMentor = new Class_Mentor(pkClassMentor1);
//			System.out.println(pkClassMentor1);
			System.out.println(classMentor);
			classMentorDAO.saveClassMentor(classMentor);
			request.setAttribute("message", "Add Success!!!");
			request.getRequestDispatcher("/showMentor").forward(request, response);;			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
