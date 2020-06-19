package cmw.models;

import java.sql.Date;
import java.util.Set;
import javax.persistence.*;
import cmw.models.Class;

@Entity
@Table(name = "CLASS")
public class Class {
  @Id
  private String classCode;
  @Column
  private String adminAccount;
  @ManyToOne
  @JoinColumn(name = "courseId", nullable = false) // check when run
  private Course course;
  @Column
  private Date expectedStartDate;
  @Column
  private Date expectedEndDate;
  @Column
  private Date actualStartDate;
  @Column
  private Date actualEndDate;
  @Column
  private boolean status;
  
  @OneToMany(mappedBy = "clazz")
  private Set<Class_Mentor> class_mentor;
  
  @OneToMany(mappedBy = "clazz")
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
  public Class(String classCode, String adminAccount, Course course, Date expectedStartDate,
      Date expectedEndDate, Date actualStartDate, Date actualEndDate, boolean status,
      Set<Class_Mentor> class_mentor) {
    super();
    this.classCode = classCode;
    this.adminAccount = adminAccount;
    this.course = course;
    this.expectedStartDate = expectedStartDate;
    this.expectedEndDate = expectedEndDate;
    this.actualStartDate = actualStartDate;
    this.actualEndDate = actualEndDate;
    this.status = status;
    this.class_mentor = class_mentor;
  }

  /**
   * 
   */
  public Class() {
    super();
  }

  public String getClassCode() {
    return classCode;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
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

  public Date getExpectedStartDate() {
    return expectedStartDate;
  }

  public void setExpectedStartDate(Date expectedStartDate) {
    this.expectedStartDate = expectedStartDate;
  }

  public Date getExpectedEndDate() {
    return expectedEndDate;
  }

  public void setExpectedEndDate(Date expectedEndDate) {
    this.expectedEndDate = expectedEndDate;
  }

  public Date getActualStartDate() {
    return actualStartDate;
  }

  public void setActualStartDate(Date actualStartDate) {
    this.actualStartDate = actualStartDate;
  }

  public Date getactualEndDate() {
    return actualEndDate;
  }

  public void setactualEndDate(Date actualEndDate) {
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
    return "Class [classCode=" + classCode + ", adminAccount=" + adminAccount + ", course=" + course
        + ", expectedStartDate=" + expectedStartDate + ", expectedEndDate=" + expectedEndDate
        + ", actualStartDate=" + actualStartDate + ", actualEndDate=" + actualEndDate
        + ", status=" + status + ", class_mentor=" + class_mentor + "]";
  }

  
}
