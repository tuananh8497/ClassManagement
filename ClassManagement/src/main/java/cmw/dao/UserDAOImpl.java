/**
 *	Internship - Campuslink
 *	DucHM11
 *	30 thg 6, 2020
 */

package cmw.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cmw.models.User;
import cmw.utils.HibernateUtils;

public class UserDAOImpl implements UserDAO{

	@Override
	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int id) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		Transaction transaction = null;
		List<User> listOfUser = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			listOfUser = session.createQuery("from User").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}

}
