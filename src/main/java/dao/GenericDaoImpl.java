package dao;

import hibernate.SessionFactoryProvider;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	private SessionFactory sessionFactory = SessionFactoryProvider
			.getSessionFactory();

	public T create(T newInstance) {
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.save(newInstance);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			sess.close();
		}
		return newInstance;
	}

	public T read(PK id) {
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		List<T> result;
		try {
			tx = sess.beginTransaction();
			result = sess.createQuery("from Index i where i.id = :id")
					.setParameter("id", id).list();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			sess.close();
		}
		return result.size() > 0 ? result.get(0) : null;
	}

	public T update(T transientObject) {
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.update(transientObject);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			sess.close();
		}
		return transientObject;
	}

	public void delete(T persistentObject) {
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.delete(persistentObject);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			sess.close();
		}
	}

}
