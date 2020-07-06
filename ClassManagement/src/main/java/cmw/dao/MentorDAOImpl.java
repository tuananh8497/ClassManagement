package cmw.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cmw.models.Mentor;
import cmw.utils.HibernateUtils;

public class MentorDAOImpl implements MentorDAO{
  /**
   * Save User
   * @param user
   */
  @Override
  public void saveMentor(Mentor mentor) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.saveOrUpdate(mentor);
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
  public void updateMentor(Mentor mentor) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.update(mentor);
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
  public void deleteMentor(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        Mentor mentor = session.get(Mentor.class, id);
        if (mentor != null) {
            session.delete(mentor);
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
  public Mentor getMentor(String accountMentor) {

    Transaction transaction = null;
    Mentor mentor= null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        mentor = session.get(Mentor.class, accountMentor);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return mentor;
  }

  @Override
  public List<Mentor> getAllMentor() {
    Transaction transaction = null;
    List <Mentor> listOfMentor = null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        listOfMentor = session.createQuery("from Mentor").getResultList();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return listOfMentor;
  }

@Override
public Mentor getMentor(int id) {
	Transaction transaction = null;
    Mentor mentor= null;
    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        mentor = session.get(Mentor.class, id);
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return mentor;
}
}
