package cmw.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int courseId;
  @Column
  private String courseName;
  @Column
  private int duration;
  
  @OneToMany(mappedBy = "course")
  private Set<Class> classes;
  
  @OneToMany(mappedBy = "course")
  private Set<Timetable> timetables;
  /**
   * @param courseId
   * @param courseName
   * @param duration
   */
  public Course(int courseId, String courseName, int duration) {
    super();
    this.courseId = courseId;
    this.courseName = courseName;
    this.duration = duration;
  }
 
  /**
   * 
   */
  public Course() {
    super();
  }
  public int getCourseId() {
    return courseId;
  }
  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
  public String getCourseName() {
    return courseName;
  }
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
  public int getDuration() {
    return duration;
  }
  public void setDuration(int duration) {
    this.duration = duration;
  }
  
  public Set<Class> getClasses() {
    return classes;
  }
  public void setClasses(Set<Class> classes) {
    this.classes = classes;
  }
  @Override
  public String toString() {
    return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration
        + "]";
  }
}
