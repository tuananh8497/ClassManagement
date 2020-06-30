package cmw.models;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PK_Class_Mentor implements Serializable{  
  
private int classId;
  private int mentorId;
  
  public PK_Class_Mentor(int classId, int mentorId) {
	super();
	this.classId = classId;
	this.mentorId = mentorId;
  }
  
  public PK_Class_Mentor() {
	super();
  }
  public int getClassId() { 
    return classId;
  }

  public void setClassId(int classId) {
    this.classId = classId;
  }
  public int getMentorId() {
    return mentorId;
  }
  public void setMentorId(int mentorId) {
    this.mentorId = mentorId;
  }

  @Override
 	public String toString() {
 		return "PK_Class_Mentor [classId=" + classId + ", mentorId=" + mentorId + "]";
 	}
  
  
}
