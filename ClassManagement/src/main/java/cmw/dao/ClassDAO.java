package cmw.dao;

import java.util.List;

public interface ClassDAO {
  public void saveClass(Class classes);
  public void updateClass(Class classes);
  public void deleteClass(int id);
  public Class getClass(int id);
  public List<Class> getAllClass();
}
