package cmw.servlet;

import java.io.IOException;
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
import cmw.dao.PointDAO;
import cmw.dao.PointDAOImpl;
import cmw.dao.SubjectDAO;
import cmw.dao.SubjectDAOImpl;
import cmw.models.Class;
import cmw.models.Person;
import cmw.models.Point;
import cmw.models.StringPoint;
import cmw.models.Subject;
import cmw.services.studentServices;

/**
 * Servlet implementation class profileStudent
 */
@WebServlet("/profileStudent")
public class profileStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public profileStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Lấy dữ liệu student
			PersonDAO personDAO = new PersonDAOImpl();
			int personId = Integer.parseInt(request.getParameter("id"));
			Person person = personDAO.getPerson(personId);
			String studentClassCode = null;
			if (person.getClazz() != null) {
				studentClassCode = person.getClazz().getClassCode();
			}
			request.setAttribute("student", person);
			
			// Tạo list status
			List<String> listStatus = new ArrayList<>();
			if(person.getStatus() == true) {
				listStatus.add("active");
				listStatus.add("inactive");
			} else {
				listStatus.add("inactive");
				listStatus.add("active");
			}
			request.setAttribute("listStatus", listStatus);

			// Lấy list classCode
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
			
			// Lấy listPoint
			PointDAO pointDAO = new PointDAOImpl();
			List<Point> listPoint = pointDAO.getAllPoint();
			
			/**
			 * Từ đây đến cuối là xử lý phần bảng điểm
			 */
			// Chỉ lấy các point liên quan đến student này
			List<Point> listPointStudent = new ArrayList<>();
			for(Point point : listPoint) {
				if(point.getPerson().getPersonId() == personId) {
					System.out.println(point.getPerson().getPersonId());
					listPointStudent.add(point);
				}
			}
			
			// Lấy listClass
			ClassDAO classDAO = new ClassDAOImpl();
			List<Class> listClass = classDAO.getAllClass();
			
			// Lấy listSubject
			SubjectDAO subjectDAO = new SubjectDAOImpl();
			List<Subject> listSubject = subjectDAO.getAllSubject();
			
			// Tạo list các đối tượng StringPoint để hiển thị sang bảng
			List<StringPoint> listStringPoint = new ArrayList<>();
			for(Point point : listPointStudent) {
				// Tạo đối tượng StringPoint mới
				StringPoint stringPoint = new StringPoint();
				for(Class clazz : listClass) {
					if(clazz.getClassId() == point.getClassId()) {
						stringPoint.setClassCode(clazz.getClassCode());
						break;
					}
				}
				for(Subject subject : listSubject) {
					if(subject.getSubjectId() == point.getSubjectId()) {
						stringPoint.setSubjectName(subject.getSubjectName());
						break;
					}
 				}
				stringPoint.setPoint(point.getPoint());
				listStringPoint.add(stringPoint);
			}
			request.setAttribute("listStringPoint", listStringPoint);
			
			request.getRequestDispatcher("/student/profileStudents.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
