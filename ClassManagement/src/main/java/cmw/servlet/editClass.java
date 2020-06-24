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
 * Servlet implementation class aditClass
 */
@WebServlet("/editClass")
public class editClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ClassManagement/class/editClass.jsp");
		ClassDAO classDao = new ClassDAOImpl();
        try {
            // get data from DB
            List<Class> listClass = classDao.getAllClass();
            // chuyen den view
            System.out.println(listClass);
            request.setAttribute("listClass", listClass);
            request.getRequestDispatcher("ClassManagement/class/editClass.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
