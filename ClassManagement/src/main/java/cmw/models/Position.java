package cmw.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POSITION")
public class Position {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int positionId;
  @Column
  private String positionName;
  
  @OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
  private Set<Person> persons;

  /**
   * @param positionId
   * @param positionName
   * @param persons
   */
  public Position(int positionId, String positionName, Set<Person> persons) {
    super();
    this.positionId = positionId;
    this.positionName = positionName;
    this.persons = persons;
  }

  /**
   * 
   */
  
  public Position() {
    super();
  }

  /**
   * @param positionName
   */
  public Position(String positionName) {
    super();
    this.positionName = positionName;
  }





  @Override
  public String toString() {
    return "Position [positionId=" + positionId + ", positionName=" + positionName + "]";
  }

  public int getPositionId() {
    return positionId;
  }

  public void setPositionId(int positionId) {
    this.positionId = positionId;
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public Set<Person> getPersons() {
    return persons;
  }

  public void setPersons(Set<Person> persons) {
    this.persons = persons;
  }


}
