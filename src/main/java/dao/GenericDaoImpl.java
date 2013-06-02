package dao;

import hibernate.SessionFactoryProvider;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Implements <code>GenericDao</code> with transactions from <code>SessionFactory</code>
 * @param <T> persisted object type
 * @param <PK> primary key type
 */
public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

    /**
     * <code>SessionFactory</code> used to handle transactions
     */
	protected SessionFactory sessionFactory = SessionFactoryProvider
			.getSessionFactory();

    /**
     * Creates new instance of an object with transaction from <code>SessionFactory</code>
     * @param newInstance instance to be created
     * @return instance created
     */
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

    /**
     * Reads object
     * @param id primary key of object to be read with transaction from <code>SessionFactory</code>
     * @return instance read
     */
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

    /**
     * Updates object
     * @param transientObject updated version of an object to be updated with transaction from <code>SessionFactory</code>
     * @return updated object
     */
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

    /**
     * Deletes object
     * @param persistentObject object to be deleted with transaction from <code>SessionFactory</code>
     */
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
