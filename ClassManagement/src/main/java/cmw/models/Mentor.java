package cmw.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mentor")
public class Mentor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int mentorId;
  @Column(unique = true)
  private String mentorAccount;
  @Column
  private String name;
  @Column
  private String bankAccount;
  @Column
  private String email;
  @Column
  private String phone;
  @Column
  private String citizenId;
  @Column
  private String address;
  @Column
  private LocalDate birthDate;
  @Column
  private String education;
  @Column
  private boolean status;
  
  @OneToMany(mappedBy = "mentor",cascade = CascadeType.ALL)
  private Set<Class_Mentor> cm;
  
  @Override
  public String toString() {
    return "Mentor [mentorId=" + mentorId + ", mentorAccount=" + mentorAccount + ", name=" + name
        + ", bankAccount=" + bankAccount + ", email=" + email + ", phone=" + phone + ", citizenId="
        + citizenId + ", address=" + address + ", birthDate=" + birthDate + ", education="
        + education + ", status=" + status + "]";
  }

  /**
   * @param mentorId
   * @param mentorAccount
   * @param name
   * @param bankAccount
   * @param email
   * @param phone
   * @param citizenId
   * @param address
   * @param birthDate
   * @param education
   * @param status
   * @param cm
   */
  public Mentor(int mentorId, String mentorAccount, String name, String bankAccount, String email,
      String phone, String citizenId, String address, LocalDate birthDate, String education,
      boolean status, Set<Class_Mentor> cm) {
    super();
    this.mentorId = mentorId;
    this.mentorAccount = mentorAccount;
    this.name = name;
    this.bankAccount = bankAccount;
    this.email = email;
    this.phone = phone;
    this.citizenId = citizenId;
    this.address = address;
    this.birthDate = birthDate;
    this.education = education;
    this.status = status;
    this.cm = cm;
  }

  public int getMentorId() {
    return mentorId;
  }

  public void setMentorId(int mentorId) {
    this.mentorId = mentorId;
  }

  public Mentor() {
    super();
  }
  public String getMentorAccount() {
    return mentorAccount;
  }
  public void setMentorAccount(String mentorAccount) {
    this.mentorAccount = mentorAccount;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getBankAccount() {
    return bankAccount;
  }
  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getCitizenId() {
    return citizenId;
  }
  public void setCitizenId(String citizenId) {
    this.citizenId = citizenId;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public LocalDate getBirthDate() {
    return birthDate;
  }
  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }
  public String getEducation() {
    return education;
  }
  public void setEducation(String education) {
    this.education = education;
  }
  public boolean isStatus() {
    return status;
  }
  public void setStatus(boolean status) {
    this.status = status;
  }
  public Set<Class_Mentor> getCm() {
    return cm;
  }
  public void setCm(Set<Class_Mentor> cm) {
    this.cm = cm;
  }

  
}
