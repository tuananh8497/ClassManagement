package cmw.dao;

import java.util.List;
import org.hibernate.*;
import cmw.utils.HibernateUtils;

public class ClassDAOImpl implements ClassDAO{

  /**
   * Save User
   * @param user
   */
  @Override
  public void saveClass(Class classes) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.save(classes);
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
  public void updateClass(Class classes) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.update(classes);
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
  public void deleteClass(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        // start a transaction
        transaction = session.beginTransaction();

        // Delete a user object
        Class classes = session.get(Class.class, id);
        if (classes != null) {
            session.delete(classes);
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
  public Class getClass(int id) {

    Transaction transaction = null;
    Class classes= null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        classes = session.get(Class.class, id);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return classes;
  }

  @Override
  public List<Class> getAllClass() {
    Transaction transaction = null;
    List <Class> listOfClasses = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        listOfClasses = session.createQuery("from User").getResultList();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return listOfClasses;
  }
}
