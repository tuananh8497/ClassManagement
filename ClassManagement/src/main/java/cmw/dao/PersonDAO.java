package cmw.dao;

import java.util.List;

import cmw.models.Person;

public interface PersonDAO {
	  public void savePerson(Person person);
	  public void updatePerson(Person person);
	  public void deletePerson(int id);
	  public Person getPerson(int id);
	  public List<Person> getAllPerson();
}
