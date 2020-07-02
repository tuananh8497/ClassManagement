package cmw.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cmw.models.Timetable;
import cmw.utils.HibernateUtils;

public class TimetableDAOImpl implements TimetableDAO{

  /**
   * Save User
   * @param user
   */
  @Override
  public void saveTimetable(Timetable timetable) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.save(timetable);
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
  public void updateTimetable(Timetable timetable) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.saveOrUpdate(timetable);
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
  public void deleteTimetable(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        Timetable timetable = session.get(Timetable.class, id);
        if (timetable != null) {
            session.delete(timetable);
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
  public Timetable getTimetable(int id) {

    Transaction transaction = null;
    Timetable timetable= null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        timetable = session.get(Timetable.class, id);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return timetable;
  }

  @Override
  public List<Timetable> getAllTimetable() {
    Transaction transaction = null;
    List <Timetable> listOfTimetable = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        listOfTimetable = session.createQuery("from Timetable").getResultList();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return listOfTimetable;
  }
}
