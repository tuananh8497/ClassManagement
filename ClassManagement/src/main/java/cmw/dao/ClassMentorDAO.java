package cmw.dao;

import java.util.List;

import cmw.models.PK_Class_Mentor;


public interface ClassMentorDAO {
	public void saveMentor(PK_Class_Mentor classMentor);
	public void updateMentor(PK_Class_Mentor classMentor);
	public void deleteMentor(int id);
	public List<PK_Class_Mentor> getClassMentor(int id);
	public List<PK_Class_Mentor> getAllClassMentor();
	PK_Class_Mentor getClassMentor(String account);
}
