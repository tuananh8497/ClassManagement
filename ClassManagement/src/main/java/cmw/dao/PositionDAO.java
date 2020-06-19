package cmw.dao;

import java.util.List;
import cmw.models.Position;

public interface PositionDAO {
  public void savePosition(Position position);
  public void updatePosition(Position position);
  public void deletePosition(int id);
  public Position getPosition(int id);
  public List<Position> getAllPosition();
}
