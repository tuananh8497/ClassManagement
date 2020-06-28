package cmw.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.MentorDAO;
import cmw.dao.MentorDAOImpl;
import cmw.models.Mentor;

/**
 * Servlet implementation class addMentor
 */
@WebServlet("/addMentor")
public class addMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMentor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/ClassManagement/mentor/addMentor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MentorDAO mentorDAO = new MentorDAOImpl();
//		int mentorId = Integer.parseInt(request.getParameter("mentorId"));
		String account = request.getParameter("account");
		String name = request.getParameter("name");
		String bankAccount = request.getParameter("bankAccount");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String citizenId = request.getParameter("citizenId");
		String address = request.getParameter("address");
		LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
		String education = request.getParameter("education");
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		Mentor mentor = new Mentor();
		mentor.setMentorAccount(account);
		mentor.setName(name);
		mentor.setBankAccount(bankAccount);
		mentor.setEmail(email);
		mentor.setPhone(phone);
		mentor.setCitizenId(citizenId);
		mentor.setAddress(address);
		mentor.setBirthDate(birthDate);
		mentor.setEducation(education);
		mentor.setStatus(status);
		System.out.println(mentor);
		try {
			mentorDAO.saveMentor(mentor);
			request.setAttribute("message", "Add Successss!!!!!");
			request.getRequestDispatcher("/showMentor").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
