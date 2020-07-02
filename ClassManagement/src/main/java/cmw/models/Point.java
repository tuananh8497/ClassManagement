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
  @JoinColumn(name = "personId", nullable = false) // check when run
  private Person person;
  @Id
  private int subjectId;
  @Id
  private int classId;
  
  private int point;

  /**
   * @param personId
   * @param subjectId
   * @param classId
   * @param point 
   */
  public Point(Person person, int subjectId, int classId, int point) {
    super();
    this.person = person;
    this.subjectId = subjectId;
    this.classId = classId;
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
    return "Point [Person=" + person + ", subjectId=" + subjectId + ", classId=" + classId
        + ", point=" + point + "]";
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  public int getClassId() {
    return classId;
  }

  public void setClassId(int classId) {
    this.classId = classId;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

}
