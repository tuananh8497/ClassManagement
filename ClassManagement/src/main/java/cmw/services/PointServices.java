/**
 *	Internship - Campuslink
 *	DucHM11
 *	2 thg 7, 2020
 */

package cmw.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.CourseDAO;
import cmw.dao.CourseDAOImpl;
import cmw.dao.TimetableDAO;
import cmw.dao.TimetableDAOImpl;
import cmw.models.Class;
import cmw.models.Point;
import cmw.models.Timetable;

public class PointServices {
	/**
	 * Sắp xếp listPoint theo ID của các Student trong list. Đầu vào là list đã được
	 * lọc theo một lớp cụ thể Mục đích là để các point của cùng một student nằm
	 * cạnh nhau trong list
	 * 
	 * @param listPoint
	 *            - list đã sắp xếp
	 */
	public void sortByStudentId(List<Point> listPoint) {
		for (int i = 0; i < listPoint.size() - 1; i++) {
			for (int j = i + 1; j < listPoint.size(); j++) {
				if (listPoint.get(j).getPerson().getPersonId() < listPoint.get(i).getPerson().getPersonId()) {
					Point tempPoint = listPoint.get(i);
					listPoint.set(i, listPoint.get(j));
					listPoint.set(j, tempPoint);
				}
			}
		}
	}

	/**
	 * Hàm get một list subject của một class cụ thể, dựa theo id của class.
	 * 
	 * @param classId
	 *            - id của class
	 * @return - list các subject của class đó
	 */
	public static List<String> getSubjectListByClassId(int classId) {
		// Khai báo các thứ cần dùng
		CourseDAO courseDAO = new CourseDAOImpl();
		ClassDAO classDAO = new ClassDAOImpl();
		TimetableDAO timetableDAO = new TimetableDAOImpl();

		// Lấy class có ID được nhập vào
		Class clazz = classDAO.getClass(classId);

		// Lấy courseId của class bên trên ra
		int courseId = clazz.getCourse().getCourseId();

		// Lấy tất cả listTimetable
		List<Timetable> listTimetable = timetableDAO.getAllTimetable();

		// Lọc ra các timetable của course bên trên
		List<Timetable> listTimetableOfCourse = new ArrayList<>();
		for (Timetable timetable : listTimetable) {
			if (timetable.getCourse().getCourseId() == courseId) {
				listTimetableOfCourse.add(timetable);
			}
		}

		List<String> listSubject = new ArrayList<>();
		for (Timetable timetable : listTimetableOfCourse) {
			listSubject.add(timetable.getSubject().getSubjectName());
		}

		return listSubject;
	}
	
	public static List<Integer> getSubjectListIdByClassId(int classId) {
		// Khai báo các thứ cần dùng
		CourseDAO courseDAO = new CourseDAOImpl();
		ClassDAO classDAO = new ClassDAOImpl();
		TimetableDAO timetableDAO = new TimetableDAOImpl();

		// Lấy class có ID được nhập vào
		Class clazz = classDAO.getClass(classId);

		// Lấy courseId của class bên trên ra
		int courseId = clazz.getCourse().getCourseId();

		// Lấy tất cả listTimetable
		List<Timetable> listTimetable = timetableDAO.getAllTimetable();

		// Lọc ra các timetable của course bên trên
		List<Timetable> listTimetableOfCourse = new ArrayList<>();
		for (Timetable timetable : listTimetable) {
			if (timetable.getCourse().getCourseId() == courseId) {
				listTimetableOfCourse.add(timetable);
			}
		}

		List<Integer> listSubjectId = new ArrayList<>();
		for (Timetable timetable : listTimetableOfCourse) {
			listSubjectId.add(timetable.getSubject().getSubjectId());
		}

		return listSubjectId;
	}

	public static Map<Integer, String> getSubjectMapByClassId(int classId) {
		// Khai báo các thứ cần dùng
		CourseDAO courseDAO = new CourseDAOImpl();
		ClassDAO classDAO = new ClassDAOImpl();
		TimetableDAO timetableDAO = new TimetableDAOImpl();

		// Lấy class có ID được nhập vào
		Class clazz = classDAO.getClass(classId);

		// Lấy courseId của class bên trên ra
		int courseId = clazz.getCourse().getCourseId();

		// Lấy tất cả listTimetable
		List<Timetable> listTimetable = timetableDAO.getAllTimetable();

		// Lọc ra các timetable của course bên trên
		List<Timetable> listTimetableOfCourse = new ArrayList<>();
		for (Timetable timetable : listTimetable) {
			if (timetable.getCourse().getCourseId() == courseId) {
				listTimetableOfCourse.add(timetable);
			}
		}
		
		Map<Integer, String> mapSubject = new HashMap<Integer, String>();
		for (Timetable timetable : listTimetableOfCourse) {
			mapSubject.put(timetable.getSubject().getSubjectId(), timetable.getSubject().getSubjectName());
		}

		return mapSubject;
	}

	public static void main(String[] args) {
		
		System.out.println(getSubjectListIdByClassId(1));
	}
}
