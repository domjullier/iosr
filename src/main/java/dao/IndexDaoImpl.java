package dao;

import model.Index;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.*;

public class IndexDaoImpl extends GenericDaoImpl<Index, String> implements IndexDao {

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

    public Map<Date, BigDecimal> getHistoricValues(String id, Date start,
                                                   Date end) {
        // TODO Automatycznie generowany szkielet metody
        throw new NotImplementedException();
    }

    public void setHistoricValue(String id, Date date, BigDecimal value) {
        // TODO Automatycznie generowany szkielet metody
        throw new NotImplementedException();
    }

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
