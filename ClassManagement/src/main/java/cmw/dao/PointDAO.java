package cmw.dao;

import java.util.List;
import cmw.models.Point;

public interface PointDAO {
  public void savePoint(Point point);
  public void updatePoint(Point point);
  public void deletePoint(int id);
  public Point getPoint(int id);
  public List<Point> getAllPoint();
}
