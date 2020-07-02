/**
 *	Internship - Campuslink
 *	DucHM11
 *	2 thg 7, 2020
 */

package cmw.services;

import java.util.ArrayList;
import java.util.List;

import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.dao.CourseDAO;
import cmw.dao.CourseDAOImpl;
import cmw.dao.TimetableDAO;
import cmw.dao.TimetableDAOImpl;
import cmw.models.Class;
import cmw.models.Timetable;

public class ClassServices {
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
		for(Timetable timetable : listTimetable) {
			if(timetable.getCourse().getCourseId() == courseId) {
				listTimetableOfCourse.add(timetable);
			}
		}
		
		List<String> listSubject = new ArrayList<>();
		for(Timetable timetable : listTimetableOfCourse) {
			listSubject.add(timetable.getSubject().getSubjectName());
		}
		
		return listSubject;
	}
	
	public static void main(String[] args) {
		System.out.println(getSubjectListByClassId(2));
	}
}
