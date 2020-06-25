package cmw.models;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PK_Class_Mentor implements Serializable{  
  
  private int classId;
  private int mentorId;
  
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

  
  
  
  
}
