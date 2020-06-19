package cmw.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POINT")
public class Point implements Serializable{
  @Id
  @ManyToOne
  @JoinColumn(name = "person_account", nullable = false) // check when run
  private Person person_account;
  @Id
  private String subjectId;
  @Id
  private String classCode;
  
  private int point;

  /**
   * @param person
   * @param subjectId
   * @param classCode
   * @param point
   */
  public Point(Person person, String subjectId, String classCode, int point) {
    super();
    this.person_account = person;
    this.subjectId = subjectId;
    this.classCode = classCode;
    this.point = point;
  }

  /**
   * 
   */
  public Point() {
    super();
  }

  @Override
  public String toString() {
    return "Point [person=" + person_account + ", subjectId=" + subjectId + ", classCode=" + classCode
        + ", point=" + point + "]";
  }

  public Person getPerson() {
    return person_account;
  }

  public void setPerson(Person person) {
    this.person_account = person;
  }

  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }

  public String getClassCode() {
    return classCode;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

}
