package cmw.dao;

import java.util.List;

import cmw.models.Class_Mentor;
import cmw.models.Mentor;
import cmw.models.PK_Class_Mentor;


public interface ClassMentorDAO {
	public void saveClassMentor(PK_Class_Mentor classMentor);
	public void updateClassMentor(PK_Class_Mentor classMentor);
	public void deleteClassMentor(int id);
	public List<PK_Class_Mentor> getClassMentor(int id);
	public List<PK_Class_Mentor> getAllClassMentor();
	PK_Class_Mentor getClassMentor(String account);
	public void saveClassMentor(int classId, int mentorId);
	public void updateClassMentor(Class_Mentor classMentor);
	public List<PK_Class_Mentor> getClassMentor(Mentor mentor);
}
