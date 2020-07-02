package cmw.models;


import javax.persistence.*;

@Entity
@Table(name = "TIMETABLE")
public class Timetable {

  @EmbeddedId
  private PK_Timetable pk;

  @ManyToOne
  @JoinColumn(name = "courseId", insertable = false, updatable = false) // check when run
  private Course course;

  @ManyToOne
  @JoinColumn(name = "subjectId", insertable = false, updatable = false) // check when run
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


  /**
   * 
   */
  public Timetable() {
    super();
  }

  /**
   * @param pk
   * @param duration
   * @param priority
   */
  public Timetable(PK_Timetable pk, int duration, int priority) {
    super();
    this.pk = pk;
    this.duration = duration;
    this.priority = priority;
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

  public PK_Timetable getPk() {
    return pk;
  }

  public void setPk(PK_Timetable pk) {
    this.pk = pk;
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

  // public int compareTo(Timetable comparePriority) {
  //
  // int comparePrio = ((Timetable) comparePriority).getPriority();
  //
  // // ascending order
  // return this.priority - comparePrio;
  //
  // }
}
