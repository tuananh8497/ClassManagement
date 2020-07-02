/**
 *	Internship - Campuslink
 *	DucHM11
 *	2 thg 7, 2020
 */

package cmw.services;

import java.util.List;

import cmw.models.Point;

public class PointServices {
	/**
	 * Sắp xếp listPoint theo ID của các Student trong list.
	 * Đầu vào là list đã được lọc theo một lớp cụ thể
	 * Mục đích là để các point của cùng một student nằm cạnh nhau trong list
	 * 
	 * @param listPoint - list đã sắp xếp
	 */
	public void sortByStudentId (List<Point> listPoint) {
		for(int i = 0; i < listPoint.size()-1; i++) {
			for(int j = i + 1; j < listPoint.size(); j++) {
				if(listPoint.get(j).getPerson().getPersonId() < listPoint.get(i).getPerson().getPersonId()) {
					Point tempPoint = listPoint.get(i);
					listPoint.set(i, listPoint.get(j));
					listPoint.set(j, tempPoint);
				}
			}
		}
	}
	
}
