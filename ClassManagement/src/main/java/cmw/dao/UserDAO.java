/**
 *	Internship - Campuslink
 *	DucHM11
 *	30 thg 6, 2020
 */

package cmw.dao;

import java.util.List;

import cmw.models.User;

public interface UserDAO {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);
	public List<User> getAllUser();
}
