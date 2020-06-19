package cmw.models;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "SUBJECT")
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int subjectId;
  @Column
  private String subjectName;
  
  @OneToMany(mappedBy = "subject")
  private Set<Timetable> timetables;
  
  /**
   * @param subjectId
   * @param subjectName
   */
  public Subject(int subjectId, String subjectName) {
    super();
    this.subjectId = subjectId;
    this.subjectName = subjectName;
  }

  /**
   * 
   */
  public Subject() {
    super();
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  @Override
  public String toString() {
    return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
  }


}
