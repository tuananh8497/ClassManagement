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
}
