package dao;

import model.Index;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.*;

/**
 * Implements <code>IndexDao</code> with transactions from <code>SessionFactory</code>
 */
public class IndexDaoImpl extends GenericDaoImpl<Index, String> implements IndexDao {

    /**
     * Gets current value of specified index with transaction from <code>SessionFactory</code>
     * @param id specified index id
     * @return specified index current value
     */
    public BigDecimal getCurrentValue(String id) {
        Session sess = sessionFactory.openSession();
        Transaction tx = null;
        BigDecimal currentValue;
        try {
            tx = sess.beginTransaction();
            currentValue = (BigDecimal) sess.createQuery("select currentValue from Index i where i.id = :id")
                    .setParameter("id", id).list().get(0);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            sess.close();
        }
        return currentValue;
    }

    /**
     * Sets current value for specified index with transaction from <code>SessionFactory</code>
     * @param id specified index id
     * @param value specified index current value
     */
    public void setCurrentValue(String id, BigDecimal value) {
        Session sess = sessionFactory.openSession();
        Transaction tx = null;
        Index transientObject;
        try {
            tx = sess.beginTransaction();
            transientObject = (Index) sess.createQuery("from Index i where i.id = :id")
                    .setParameter("id", id).list().get(0);
            transientObject.setCurrentValue(value);
            sess.update(transientObject);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            sess.close();
        }
    }

    /**
     * Not implemented
     * @param id specified index id
     * @param start beginning of specified time span
     * @param end end of specified time span
     * @return nothing
     */
    public Map<Date, BigDecimal> getHistoricValues(String id, Date start,
                                                   Date end) {
        // TODO Automatycznie generowany szkielet metody
        throw new NotImplementedException();
    }

    /**
     * Not implemented
     * @param id specified index id
     * @param date date of historic value
     * @param value historic value for given date
     */
    public void setHistoricValue(String id, Date date, BigDecimal value) {
        // TODO Automatycznie generowany szkielet metody
        throw new NotImplementedException();
    }

    /**
     * Gets current values of all indexes with transaction from <code>SessionFactory</code>
     * @return <code>Collection</code> of <code>Index</code>es with their current values
     */
    public Collection<Index> getAllCurrentValues() {
        Session sess = sessionFactory.openSession();
        Transaction tx = null;
        List<Object[]> values;
        try {
            tx = sess.beginTransaction();
            values = sess.createQuery("select id, currentValue, currency from Index i")
                    .list();
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            sess.close();
        }

        Collection<Index> currentValuesMap = new ArrayList<Index>();
        for (Object[] currentIndex : values) {
            Index index = new Index();
            index.setId((String) currentIndex[0]);
            index.setCurrentValue((BigDecimal) currentIndex[1]);
            index.setCurrency((String) currentIndex[2]);
            currentValuesMap.add(index);
        }

        return currentValuesMap;
    }

}
