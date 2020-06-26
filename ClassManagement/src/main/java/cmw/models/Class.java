package cmw.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import cmw.models.Class;

@Entity
@Table(name = "CLASS")
public class Class {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int classId;
  @Column(unique = true)
  private String classCode;
  @Column
  private String adminAccount;
  @ManyToOne
  @JoinColumn(name = "courseId", nullable = false) // check when run
  private Course course;
  @Column
  private LocalDate expectedStartDate;
  @Column
  private LocalDate expectedEndDate;
  @Column
  private LocalDate actualStartDate;
  @Column
  private LocalDate actualEndDate;
  
  
  @Column
  private boolean status;

  @OneToMany(mappedBy = "clazz",cascade = CascadeType.ALL)
  private Set<Class_Mentor> class_mentor;

  @OneToMany(mappedBy = "clazz",cascade = CascadeType.ALL)
  private Set<Person> persons;


  /**
   * @param classCode
   * @param adminAccount
   * @param course
   * @param expectedStartDate
   * @param expectedEndDate
   * @param actualStartDate
   * @param actualEndDate
   * @param status
   * @param cm
   */

  /**
   * 
   */
  public Class() {
    super();
  }



  /**
   * @param id
   * @param classCode
   * @param adminAccount
   * @param course
   * @param expectedStartDate
   * @param expectedEndDate
   * @param actualStartDate
   * @param actualEndDate
   * @param status
   * @param class_mentor
   * @param persons
   */
  public Class(int classId, String classCode, String adminAccount, Course course, LocalDate expectedStartDate,
      LocalDate expectedEndDate, LocalDate actualStartDate, LocalDate actualEndDate, boolean status,
      Set<Class_Mentor> class_mentor, Set<Person> persons) {
    super();
    this.classId = classId;
    this.classCode = classCode;
    this.adminAccount = adminAccount;
    this.course = course;
    this.expectedStartDate = expectedStartDate;
    this.expectedEndDate = expectedEndDate;
    this.actualStartDate = actualStartDate;
    this.actualEndDate = actualEndDate;
    this.status = status;
    this.class_mentor = class_mentor;
    this.persons = persons;
  }

  
  
  /**
   * @param classCode
   * @param course
   * @param expectedStartDate
   * @param status
   */
  public Class(String classCode, Course course, LocalDate expectedStartDate) {
    super();
    this.classCode = classCode;
    this.course = course;
    this.expectedStartDate = expectedStartDate;
    this.status = false;
  }



  public int getClassId() {
    return classId;
  }



  public void setClassId(int classId) {
    this.classId = classId;
  }



  public String getClassCode() {
    return classCode;
  }



  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }



  public LocalDate getActualEndDate() {
    return actualEndDate;
  }

  public void setActualEndDate(LocalDate actualEndDate) {
    this.actualEndDate = actualEndDate;
  }

  public Set<Class_Mentor> getClass_mentor() {
    return class_mentor;
  }

  public void setClass_mentor(Set<Class_Mentor> class_mentor) {
    this.class_mentor = class_mentor;
  }

  public Set<Person> getPersons() {
    return persons;
  }

  public void setPersons(Set<Person> persons) {
    this.persons = persons;
  }

  public String getAdminAccount() {
    return adminAccount;
  }

  public void setAdminAccount(String adminAccount) {
    this.adminAccount = adminAccount;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public LocalDate getExpectedStartDate() {
    return expectedStartDate;
  }

  public void setExpectedStartDate(LocalDate expectedStartDate) {
    this.expectedStartDate = expectedStartDate;
  }

  public LocalDate getExpectedEndDate() {
    return expectedEndDate;
  }

  public void setExpectedEndDate(LocalDate expectedEndDate) {
    this.expectedEndDate = expectedEndDate;
  }

  public LocalDate getActualStartDate() {
    return actualStartDate;
  }

  public void setActualStartDate(LocalDate actualStartDate) {
    this.actualStartDate = actualStartDate;
  }

  public LocalDate getactualEndDate() {
    return actualEndDate;
  }

  public void setactualEndDate(LocalDate actualEndDate) {
    this.actualEndDate = actualEndDate;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Set<Class_Mentor> getCm() {
    return class_mentor;
  }

  public void setCm(Set<Class_Mentor> class_mentor) {
    this.class_mentor = class_mentor;
  }

  @Override
  public String toString() {
    return "Class [classId=" + classId + ", classCode=" + classCode + ", adminAccount="
        + adminAccount + ", course=" + course + ", expectedStartDate=" + expectedStartDate
        + ", expectedEndDate=" + expectedEndDate + ", actualStartDate=" + actualStartDate
        + ", actualEndDate=" + actualEndDate + ", status=" + status + ", class_mentor="
        + class_mentor + ", persons=" + persons + "]";
  }



}
