package cmw.dao;

import java.util.List;
import cmw.models.Subject;

public interface SubjectDAO {
  public void saveSubject(Subject subject);
  public void updateSubject(Subject subject);
  public void deleteSubject(int id);
  public Subject getSubject(int id);
  public List<Subject> getAllSubject();
}
