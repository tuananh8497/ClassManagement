package cmw.models;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PK_Class_Mentor implements Serializable{
 private  String classCode;
  private String mentorAccount;
  
  public String getClassCode() {
    return classCode;
  }
  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }
  public String getMentorAccount() {
    return mentorAccount;
  }
  public void setMentorAccount(String mentorAccount) {
    this.mentorAccount = mentorAccount;
  }
  
  
}
