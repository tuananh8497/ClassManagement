package cmw.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.CourseDAO;
import cmw.dao.CourseDAOImpl;
import cmw.dao.PersonDAO;
import cmw.dao.PersonDAOImpl;
import cmw.dao.PointDAO;
import cmw.dao.PointDAOImpl;
import cmw.dao.SubjectDAO;
import cmw.dao.SubjectDAOImpl;
import cmw.dao.TimetableDAO;
import cmw.dao.TimetableDAOImpl;
import cmw.models.Class;
import cmw.models.Course;
import cmw.models.Person;
import cmw.models.Point;
import cmw.models.StringPoint;
import cmw.models.Subject;
import cmw.models.Timetable;
import cmw.services.DateProcess;
import cmw.services.PointServices;
import cmw.services.studentServices;

/**
 * Servlet implementation class profileClass
 */
@WebServlet("/profileClass")
public class profileClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public profileClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int classId = Integer.parseInt(request.getParameter("classId"));
		PersonDAO personDAO = new PersonDAOImpl();
		ClassDAO classDao = new ClassDAOImpl();
		CourseDAO courseDAO = new CourseDAOImpl();
		SubjectDAO subjectDAO = new SubjectDAOImpl();
		TimetableDAO timetableDAO = new TimetableDAOImpl();
		DateProcess dp = new DateProcess();

		// get courseId by classId
		Class clazz = classDao.getClass(classId);
		int courseId = clazz.getCourse().getCourseId();

		try {
			// get data from DB
			List<Person> listPer1 = new ArrayList<Person>();
			List<Person> listPer2 = new ArrayList<Person>();
			List<Person> persons = personDAO.getAllPerson();

			List<Course> listCourse = courseDAO.getAllCourse();
			List<Subject> listSubject = subjectDAO.getAllSubject();
			List<Timetable> timetable = timetableDAO.getAllTimetable();
			List<Timetable> timetableReturn = new ArrayList<>();

			// get students from specific CLASS ID
			for (Person person : persons) {
				if (classId == person.getClazz().getClassId() && person.getPosition().getPositionId() == 1) {
					listPer1.add(person);
				}
			}

			// get all students
			for (Person student : persons) {
				if (student.getPosition().getPositionId() == 1) {
					listPer2.add(student);
				}
			}
			int sum = 0;
			// RETURN TIMETABLE BY COURSE ID
			for (Timetable tkb : timetable) {
				if (tkb.getCourse().getCourseId() == courseId) {
					timetableReturn.add(tkb);
					sum += tkb.getDuration();
				}
			}
			LocalDate firstStartDate = clazz.getExpectedStartDate();
			LocalDate startDate;
			LocalDate endDate;

			HashMap<Long, LocalDate> startDateMap = new HashMap<Long, LocalDate>();

			HashMap<Long, LocalDate> endDateMap = new HashMap<Long, LocalDate>();

			for (int i = 0; i < timetableReturn.size(); i++) {
				int currentDuration = timetableReturn.get(i).getDuration();
				if (i == 0) {
					startDate = firstStartDate;
					endDate = dp.addDaysSkippingWeekends(startDate, currentDuration);
					System.out.println("#" + i + " - " + timetableReturn.get(i).getSubject().getSubjectName()
							+ "- START: " + startDate + " - END: " + endDate);
					startDateMap.put((long) i, startDate);
					endDateMap.put((long) i, endDate);
				} else {
					startDate = endDateMap.get((long) i - 1);
					endDate = dp.addDaysSkippingWeekends(startDate, currentDuration);
					System.out.println("#" + i + " - " + timetableReturn.get(i).getSubject().getSubjectName()
							+ "- START: " + startDate + " - END: " + endDate);
					startDateMap.put((long) i, startDate);
					endDateMap.put((long) i, endDate);
				}
			}
			studentServices services = new studentServices();
			List<Person> listStudent = services.showStudents(listPer2);
			LocalDate returnEndDate = dp.addDaysSkippingWeekends(firstStartDate, sum);
			Class class1 = classDao.getClass(classId);
			class1.setExpectedEndDate(returnEndDate); // save exepected EndDate

			request.setAttribute("class1", class1);
			request.setAttribute("listPer", listPer1);
			request.setAttribute("listCourse", listCourse);
			request.setAttribute("listSubject", listSubject);
			request.setAttribute("listStudent", listStudent);
			request.setAttribute("timetable", timetableReturn);
			request.setAttribute("startDateMap", startDateMap);
			request.setAttribute("endDateMap", endDateMap);
			request.setAttribute("returnEndDate", returnEndDate);
			request.setAttribute("sum", sum);

			classDao.updateClass(class1);

			/**
			 * Từ đây xuống cuối là xử lý vụ bảng điểm (transcript)
			 */
			// Lấy tất cả các point
			PointDAO pointDAO = new PointDAOImpl();
			List<Point> listPoint = pointDAO.getAllPoint();

			// Lọc ra các point của class hiện tại
			List<Point> listPointClass = new ArrayList<>();
			for (Point point : listPoint) {
				if (point.getClassId() == classId) {
					listPointClass.add(point);
					
				}
			}

			// Sắp xếp các point theo thứ tự các person
			PointServices pointServices = new PointServices();
			pointServices.sortByStudentId(listPointClass);

			// Lấy list student
			List<Person> listStudent1 = personDAO.getAllPerson();

			// Lấy listSubject
			List<Subject> listSubject1 = subjectDAO.getAllSubject();

			// Tạo list Stringpoint để hiển thị sang bảng
			List<StringPoint> listStringPoint = new ArrayList<>();
			for (Point point : listPointClass) {
				// Tạo đối tượng StringPoint mới
				StringPoint stringPoint = new StringPoint();
				for (Person person : listStudent1) {
					if (person.getPersonId() == point.getPerson().getPersonId()) {
						stringPoint.setStudentName(person.getName());
						stringPoint.setAccount(person.getAccount());
						break;
					}
				}
				for (Subject subject : listSubject1) {
					if (subject.getSubjectId() == point.getSubjectId()) {
						stringPoint.setSubjectName(subject.getSubjectName());
						break;
					}
				}
				stringPoint.setPoint(point.getPoint());
				listStringPoint.add(stringPoint);
			}
			request.setAttribute("listStringPoint", listStringPoint);

			request.getRequestDispatcher("/class/profile.jsp").forward(request, response);
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
		doGet(request, response);
	}
}
