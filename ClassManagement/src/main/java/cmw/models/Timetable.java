package cmw.models;


import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "TIMETABLE")
public class Timetable {
  
  @EmbeddedId
  private PK_Timetable pk;
  
  @ManyToOne
  @JoinColumn(name = "courseId",insertable =false , updatable=false) // check when run
  private Course course;
  
  @ManyToOne
  @JoinColumn(name = "subjectId",insertable =false , updatable=false) // check when run
  private Subject subject;
  
  @Column
  private int duration;
  @Column
  private int priority;
  /**
   * @param course
   * @param subject
   * @param duration
   * @param priority
   */
  public Timetable(Course course, Subject subject, int duration, int priority) {
    super();
    this.course = course;
    this.subject = subject;
    this.duration = duration;
    this.priority = priority;
  }
  /**
   * 
   */
  public Timetable() {
    super();
  }
  public Course getCourse() {
    return course;
  }
  public void setCourse(Course course) {
    this.course = course;
  }
  public Subject getSubject() {
    return subject;
  }
  public void setSubject(Subject subject) {
    this.subject = subject;
  }
  public int getDuration() {
    return duration;
  }
  public void setDuration(int duration) {
    this.duration = duration;
  }
  public int getPriority() {
    return priority;
  }
  public void setPriority(int priority) {
    this.priority = priority;
  }
  @Override
  public String toString() {
    return "Timetable [course=" + course + ", subject=" + subject + ", duration=" + duration
        + ", priority=" + priority + "]";
  }
}
