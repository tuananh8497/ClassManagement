package cmw.models;

import javax.persistence.*;

@Entity
@Table(name="CLASS_MENTOR")
public class Class_Mentor {
  
  @EmbeddedId
  private PK_Class_Mentor pk;
  
  @ManyToOne
  @JoinColumn(name = "classId",insertable =false , updatable=false) // check when run
  private Class clazz;
  
 
  @ManyToOne
  @JoinColumn(name = "mentorId", insertable = false , updatable =false) // check when run
  private Mentor mentor;

  public Class_Mentor() {
    super();
  }

  public Class_Mentor(PK_Class_Mentor pk) {
	super();
	this.pk = pk;
  }

  @Override
  public String toString() {
	return "Class_Mentor [clazz=" + clazz + ", mentor=" + mentor + "]";
  }

  public PK_Class_Mentor getPk() {
	return pk;
  }

  public void setPk(PK_Class_Mentor pk) {
	this.pk = pk;
  }

  public Class getClazz() {
	return clazz;
  }

  public void setClazz(Class clazz) {
	this.clazz = clazz;
  }

  public Mentor getMentor() {
	return mentor;
  }

  public void setMentor(Mentor mentor) {
	this.mentor = mentor;
  }
}

