package cmw.dao;

import java.util.List;
import cmw.models.Course;

public interface CourseDAO {
  public void saveCourse(Course Coursees);
  public void updateCourse(Course Coursees);
  public void deleteCourse(int id);
  public Course getCourse(int id);
  public List<Course> getAllCourse();
}
