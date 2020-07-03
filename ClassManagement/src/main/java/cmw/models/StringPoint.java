/**
 *	Internship - Campuslink
 *	DucHM11
 *	2 thg 7, 2020
 */

/**
 * Lớp này được tạo ra chỉ với mục đích hiển thị bảng điểm
 */
package cmw.models;

public class StringPoint {
	private String account;
	private String studentName;
	private String classCode;
	private String subjectName;
	private int point;
	
	public StringPoint() {
		
	}
	
	public StringPoint(String classCode, String subjectName, int point) {
		this.classCode = classCode;
		this.subjectName = subjectName;
		this.point = point;
	}
	
	

	public StringPoint(String account, String studentName, String subjectName, int point) {
		this.account = account;
		this.studentName = studentName;
		this.subjectName = subjectName;
		this.point = point;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
