package cmw.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cmw.models.Class_Mentor;
import cmw.models.Mentor;
import cmw.models.PK_Class_Mentor;
import cmw.utils.HibernateUtils;

public class ClassMentorDAOImpl implements ClassMentorDAO {

	@Override
	public void saveClassMentor(PK_Class_Mentor classMentor) {
		Transaction transaction = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(classMentor);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updateClassMentor(PK_Class_Mentor classMentor) {
		Transaction transaction = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.update(classMentor);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteClassMentor(int id) {
		Transaction transaction = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        PK_Class_Mentor classMentor = session.get(PK_Class_Mentor.class, id);
	        if (classMentor != null) {
	            session.delete(classMentor);
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
	public List<PK_Class_Mentor> getClassMentor(int id) {
		Transaction transaction = null;
	    List<PK_Class_Mentor> classMentor= null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        classMentor = session.createQuery("from Class_Mentor where mentorId = " + id).getResultList();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return classMentor;
	}

	@Override
	public List<PK_Class_Mentor> getAllClassMentor() {
		Transaction transaction = null;
	    List <PK_Class_Mentor> listOfClassMentor = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        listOfClassMentor = session.createQuery("from Class_Mentor").getResultList();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return listOfClassMentor;
	}

	@Override
	public PK_Class_Mentor getClassMentor(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveClassMentor(int classId, int mentorId) {
		Transaction transaction = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        String hql = "INSERT INTO class_mentor(classId, mentorId) SELECT classId, mentorId FROM class, mentor WHERE classId =" + classId + " AND mentorId =" + mentorId;
	        session.createQuery(hql).executeUpdate();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	}

	@Override
	public void updateClassMentor(Class_Mentor classMentor) {
		Transaction transaction = null;
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.update(classMentor);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	}

	@Override
	public List<PK_Class_Mentor> getClassMentor(Mentor mentor) {
		// TODO Auto-generated method stub
		return null;
	}

}
