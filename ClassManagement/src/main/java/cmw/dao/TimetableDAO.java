package cmw.dao;

import java.util.List;
import cmw.models.Timetable;

public interface TimetableDAO {
  public void saveTimetable(Timetable Timetable);
  public void updateTimetable(Timetable Timetable);
  public void deleteTimetable(int id);
  public Timetable getTimetable(int id);
  public List<Timetable> getAllTimetable();
}
