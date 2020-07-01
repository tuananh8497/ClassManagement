/**
 *	Internship - Campuslink
 *	DucHM11
 *	30 thg 6, 2020
 */

package cmw.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(unique = true, length = 30, nullable = false)
	private String userName;

	@Column(length = 64, nullable = false)
	private String hashPassword;
	
	// constructors
	public User() {
		super();
	}
	
	public User(String userName, String hashPassword) {
		super();
		this.userName = userName;
		this.hashPassword = hashPassword;
	}

	public User(int userId, String userName, String hashPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.hashPassword = hashPassword;
	}

	// getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", hashPassword=" + hashPassword + "]";
	}
}
