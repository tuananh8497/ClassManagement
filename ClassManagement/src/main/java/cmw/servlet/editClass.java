package cmw.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.models.Class;
import cmw.models.Course;

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
		ClassDAO classDao = new ClassDAOImpl();
        try {
            List<Class> listClass = classDao.getAllClass();
            request.setAttribute("listClass", listClass);
            request.getRequestDispatcher("/class/editClass.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
      register(request, response);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ParseException {
	  ClassDAO classDAO = new ClassDAOImpl();
      Class clazz = new Class();

	  String classCode = request.getParameter("classCode");
      String adminAccount = request.getParameter("adminAccount");
      String expectStartDate =  request.getParameter("expectedStartDate");
      String expectEndDate = request.getParameter("expectedEndDate");
      String actStartDate = request.getParameter("expectedEndDate");
      String actEndDate = request.getParameter("expectedEndDate");
      
      Date expectedStartDate = (Date) new SimpleDateFormat().parse(expectStartDate);
      Date expectedEndDate = (Date) new SimpleDateFormat().parse(expectEndDate);
      Date actualStartDate = (Date) new SimpleDateFormat().parse(actStartDate);
      Date actualEndDate = (Date) new SimpleDateFormat().parse(actEndDate);
      
      clazz.setClassCode(classCode);
      clazz.setAdminAccount(adminAccount);
      clazz.setExpectedStartDate(expectedStartDate);
      clazz.setExpectedEndDate(expectedEndDate);     
      clazz.setActualStartDate(actualStartDate);
      clazz.setactualEndDate(actualEndDate);
      System.out.println(clazz);
      
      classDAO.updateClass(clazz);;

      RequestDispatcher dispatcher = request.getRequestDispatcher("showClass.jsp");
      dispatcher.forward(request, response);
  }
}
