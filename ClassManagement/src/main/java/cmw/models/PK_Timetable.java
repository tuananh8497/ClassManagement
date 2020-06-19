package cmw.models;

import java.io.Serializable;

public class PK_Timetable implements Serializable{
 private  int courseId;
  private int subjectId;
  
  public int getCourseId() {
    return courseId;
  }
  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }
  public int getSubjectId() {
    return subjectId;
  }
  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }
  
  
}