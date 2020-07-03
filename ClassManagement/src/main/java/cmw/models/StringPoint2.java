/**
 *	Internship - Campuslink
 *	DucHM11
 *	3 thg 7, 2020
 */

/**
 * Lớp này được tạo ra chỉ để hiển thị bảng điểm trong class
 */

package cmw.models;

import java.util.List;

public class StringPoint2 {
	private String account;
	private String name;
	
	private List<Integer> listPoint;
	
	public StringPoint2() {		
	}

	public StringPoint2(String account, String name, List<Integer> listPoint) {
		this.account = account;
		this.name = name;
		this.listPoint = listPoint;
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

	public List<Integer> getListPoint() {
		return listPoint;
	}

	public void setListPoint(List<Integer> listPoint) {
		this.listPoint = listPoint;
	}
}
