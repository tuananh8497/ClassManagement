package cmw.models;

import javax.persistence.*;

@Entity
@Table(name="CLASS_MENTOR")
public class Class_Mentor {
  
  @EmbeddedId
  private PK_Class_Mentor pk;
  
  @ManyToOne
  @JoinColumn(name = "classCode",insertable =false , updatable=false) // check when run
  private Class clazz;
  
 
  @ManyToOne
  @JoinColumn(name = "mentorAccount", insertable = false , updatable =false) // check when run
  private Mentor mentor;
  /**
   * @param clazz
   * @param mentor
   */
  public Class_Mentor(Class clazz, Mentor mentor) {
    super();
    this.clazz = clazz;
    this.mentor = mentor;
  }
  
  /**
   * 
   */
  public Class_Mentor() {
    super();
  }

  @Override
  public String toString() {
    return "Class_Mentor [clazz=" + clazz + ", mentor=" + mentor + "]";
  }
  public Class getclazz() {
    return clazz;
  }
  public void setclazz(Class clazz) {
    this.clazz = clazz;
  }
  public Mentor getMentor() {
    return mentor;
  }
  public void setMentor(Mentor mentor) {
    this.mentor = mentor;
  }
  
  
}
