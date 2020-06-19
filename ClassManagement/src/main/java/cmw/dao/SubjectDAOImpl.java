package cmw.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cmw.models.Subject;
import cmw.utils.HibernateUtils;

public class SubjectDAOImpl implements SubjectDAO {

  /**
   * Save User
   * @param user
   */
  @Override
  public void saveSubject(Subject subject) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.save(subject);
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
  public void updateSubject(Subject subject) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.update(subject);
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
  public void deleteSubject(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        Subject subject = session.get(Subject.class, id);
        if (subject != null) {
            session.delete(subject);
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
  public Subject getSubject(int id) {

    Transaction transaction = null;
    Subject subject= null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        subject = session.get(Subject.class, id);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return subject;
  }

  @Override
  public List<Subject> getAllSubject() {
    Transaction transaction = null;
    List <Subject> listOfSubject = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        listOfSubject = session.createQuery("from Subject").getResultList();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return listOfSubject;
  }
}
