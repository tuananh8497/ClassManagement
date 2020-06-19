package cmw.dao;

import java.util.List;
import cmw.models.Mentor;

public interface MentorDAO {
  public void saveMentor(Mentor mentor);
  public void updateMentor(Mentor mentor);
  public void deleteMentor(int id);
  public Mentor getMentor(int id);
  public List<Mentor> getAllMentor();
}
