package cmw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmw.dao.UserDAO;
import cmw.dao.UserDAOImpl;
import cmw.models.User;
import cmw.services.UserServices;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDAO userDAO = new UserDAOImpl();
			UserServices services = new UserServices();
			
			// Lấy thông tin username và password được nhập từ form
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// Băm password thành hashPassword
			String hashPassword = services.hashString(password);

			// Lấy danh sách toàn bộ User từ DB
			List<User> listUser = userDAO.getAllUser();
			
			// Lấy ra currentUser có username trùng với tên đăng nhập hiện tại
			User currentUser = null; 
			for(User user : listUser) {
				if(user.getUserName().equals(username)) {
					currentUser = user;
					break;
				}
			}
			
			if((currentUser != null) && currentUser.getHashPassword().equals(hashPassword)) {
				System.out.println("Login success!!");

				HttpSession session = request.getSession();
				session.setAttribute("username", username);

				response.sendRedirect("home.jsp");
			} else {
				System.out.println("Login fail!!");

				request.setAttribute("msg", "Username or password wrong!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
