/**
 *	Internship - Campuslink
 *	DucHM11
 *	1 thg 7, 2020
 */

package cmw.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServices {
	public String hashString(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
}
