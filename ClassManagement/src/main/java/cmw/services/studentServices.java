/**
 *	Internship - Campuslink
 *	DucHM11
 *	25 thg 6, 2020
 */

package cmw.services;

import java.util.ArrayList;
import java.util.List;

import cmw.dao.ClassDAO;
import cmw.dao.ClassDAOImpl;
import cmw.models.Person;
import cmw.models.Class;

public class studentServices {
	public List<Person> showStudents(List<Person> list) {
		List<Person> listReturn = new ArrayList<Person>();
		for(Person person : list) {
			if(person.getPosition().getPositionId() == 1) {
				listReturn.add(person);
			}
		}
		return listReturn;
	}
	
	public List<Person> searchByAccount(String account, List<Person> list) {
		List<Person> listReturn = new ArrayList<Person>();
		for (Person person : list) {
			if ((person.getAccount().toLowerCase().indexOf(account.toLowerCase()) != -1) && (person.getPosition().getPositionId() == 1)) {
				listReturn.add(person);
			}
		}
		return listReturn;
	}

	public List<Person> searchByName(String name, List<Person> list) {
		List<Person> listReturn = new ArrayList<Person>();
		for (Person person : list) {
			if ((person.getName().toLowerCase().indexOf(name.toLowerCase()) != -1) && (person.getPosition().getPositionId() == 1)) {
				listReturn.add(person);
			}
		}
		return listReturn;
	}

	public List<Person> searchByClass(String classCode, List<Person> list) {
		List<Person> listReturn = new ArrayList<Person>();
		for (Person person : list) {
			if(person.getClazz() != null) {
				if ((person.getClazz().getClassCode().toLowerCase().indexOf(classCode.toLowerCase()) != -1) && (person.getPosition().getPositionId() == 1)) {
					listReturn.add(person);
				}
			}
		}
		return listReturn;
	}
	
	public static List<String> getAllClassCode() {
		List<String> listClassCode = new ArrayList<>();
		ClassDAO classDAO = new ClassDAOImpl();
		List<Class> listClass = classDAO.getAllClass();
		for(Class clazz : listClass) {
			if(!listClassCode.contains(clazz.getClassCode())) {
				listClassCode.add(clazz.getClassCode());
			}
		}
		return listClassCode;
	}
	
}
