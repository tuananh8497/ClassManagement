package cmw.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	@Column(unique = true)
	private String account;
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
	private Date birthDate;
	@Column
	private String education;
	@Column
	private boolean status;
	@ManyToOne
	@JoinColumn(name = "positionId", nullable = false) // check when run
	private Position position;
	@ManyToOne
	@JoinColumn(name = "classId", insertable = false, updatable = false) // check when run
	private Class clazz;
	@OneToMany(mappedBy = "person")
	private Set<Point> points;

	/**
	 * @param account
	 * @param name
	 * @param bankAccount
	 * @param email
	 * @param phone
	 * @param citizenId
	 * @param address
	 * @param birthDate
	 * @param education
	 * @param status
	 * @param position
	 * @param clazz
	 * @param points
	 */
	/**
	 * 
	 */
	public Person() {
		super();
	}

	/**
	 * @param personId
	 * @param account
	 * @param name
	 * @param bankAccount
	 * @param email
	 * @param phone
	 * @param citizenId
	 * @param address
	 * @param birthDate
	 * @param education
	 * @param status
	 * @param position
	 * @param clazz
	 * @param points
	 */
	public Person(int personId, String account, String name, String bankAccount, String email, String phone,
			String citizenId, String address, Date birthDate, String education, boolean status, Position position,
			Class clazz, Set<Point> points) {
		super();
		this.personId = personId;
		this.account = account;
		this.name = name;
		this.bankAccount = bankAccount;
		this.email = email;
		this.phone = phone;
		this.citizenId = citizenId;
		this.address = address;
		this.birthDate = birthDate;
		this.education = education;
		this.status = status;
		this.position = position;
		this.clazz = clazz;
		this.points = points;
	}
	
	
	public Person(String account, String name, String bankAccount, String email, String phone, String citizenId,
			String address, Date birthDate, String education, boolean status, Position position) {
		super();
		this.account = account;
		this.name = name;
		this.bankAccount = bankAccount;
		this.email = email;
		this.phone = phone;
		this.citizenId = citizenId;
		this.address = address;
		this.birthDate = birthDate;
		this.education = education;
		this.status = status;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", account=" + account + "]";
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Set<Point> getPoints() {
		return points;
	}

	public void setPoints(Set<Point> points) {
		this.points = points;
	}

}
