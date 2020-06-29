package cmw.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.models.Person;
import cmw.services.studentServices;
import cmw.models.Class;

/**
 * Servlet implementation class editStudent
 */
@WebServlet("/editStudent")
public class editStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/ClassManagement/student/profileStudent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Khai báo các DAO cần dùng
		PersonDAO personDAO = new PersonDAOImpl();
		ClassDAO classDAO = new ClassDAOImpl();

		// Lấy id của student cẩn sửa thông tin
		int studentId = Integer.parseInt(request.getParameter("studentId"));

		// Lấy student từ DB thông qua id bên trên
		Person student = personDAO.getPerson(studentId);

		// get dữ liệu từ form
		String account = request.getParameter("account");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String stringDateOfBirth = request.getParameter("dateOfBirth");
		LocalDate dateOfBirth = LocalDate.parse(stringDateOfBirth);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String school = request.getParameter("school");
		String citizenId = request.getParameter("citizenId");
		String bankAccount = request.getParameter("bankAccount");
		String classCode = request.getParameter("classCode");
		String strStatus = request.getParameter("status");
		boolean status = (strStatus.equals("active"));

		// Lấy danh sách tất cả các Class có trong DB
		List<Class> listClass = classDAO.getAllClass();

		// Lấy ra Class có classCode giống như form edit.
		Class clazz = null;
		for (Class clazz1 : listClass) {
			if (clazz1.getClassCode().equals(classCode)) {
				clazz = clazz1;
				break;
			}
		}

		// set các thông tin từ form vào student
		student.setAccount(account);
		student.setName(name);
		student.setAddress(address);
		student.setBirthDate(dateOfBirth);
		student.setEmail(email);
		student.setPhone(phone);
		student.setEducation(school);
		student.setCitizenId(citizenId);
		student.setBankAccount(bankAccount);
		student.setStatus(status);
		student.setClazz(clazz);

		// update!!!!!!!!!
		personDAO.updatePerson(student);

		/**
		 * Từ đây đến hết là tạo các biến để hiển thị lại profileStudent
		 */
		String studentClassCode = null;
		if (student.getClazz() != null) {
			studentClassCode = student.getClazz().getClassCode();
		}
		request.setAttribute("student", student);

		// Tạo list status
		List<String> listStatus = new ArrayList<>();
		if (student.getStatus() == true) {
			listStatus.add("active");
			listStatus.add("inactive");
		} else {
			listStatus.add("inactive");
			listStatus.add("active");
		}
		request.setAttribute("listStatus", listStatus);

		// Lấy list class
		studentServices services = new studentServices();
		List<String> listClassCode = services.getAllClassCode();

		// Đổi chỗ cho classCode của student hiện tại lên đầu danh sách
		if (studentClassCode != null) {
			for (int i = 0; i < listClassCode.size(); i++) {
				if (listClassCode.get(i).equals(studentClassCode)) {
					String temp = listClassCode.get(0);
					listClassCode.set(0, studentClassCode);
					listClassCode.set(i, temp);
					break;
				}
			}
		}
		request.setAttribute("listClassCode", listClassCode);

		request.getRequestDispatcher("/student/profileStudents.jsp").forward(request, response);
	}

}
