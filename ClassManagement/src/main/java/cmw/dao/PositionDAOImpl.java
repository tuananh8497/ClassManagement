package cmw.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cmw.models.Position;
import cmw.utils.HibernateUtils;

public class PositionDAOImpl implements PositionDAO {
  /**
   * Save User
   * @param user
   */
  @Override
  public void savePosition(Position position) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.save(position);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
  }

  /**
   * Update User
   * @param user
   */
  @Override
  public void updatePosition(Position position) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.update(position);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
  }

  /**
   * Delete User
   * @param id
   */
  @Override
  public void deletePosition(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        Position position = session.get(Position.class, id);
        if (position != null) {
            session.delete(position);
        }
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
  }

  /**
   * Get User By ID
   * @param id
   * @return
   */
  @Override
  public Position getPosition(int id) {

    Transaction transaction = null;
    Position position= null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        position = session.get(Position.class, id);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return position;
  }

  @Override
  public List<Position> getAllPosition() {
    Transaction transaction = null;
    List <Position> listOfPosition = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        listOfPosition = session.createQuery("from Position").getResultList();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return listOfPosition;
  }
}
