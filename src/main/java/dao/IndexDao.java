package dao;

import model.Index;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Interface for additional actions suitable for index Data Access Object
 */
public interface IndexDao extends GenericDao<Index, String> {

    /**
     * Gets current value of specified index
     * @param id specified index id
     * @return specified index current value
     */
    BigDecimal getCurrentValue(String id);

    /**
     * Sets current value for specified index
     * @param id specified index id
     * @param value specified index current value
     */
    void setCurrentValue(String id, BigDecimal value);

    /**
     * Gets historic values for specific index and for specified time span
     * @param id specified index id
     * @param start beginning of specified time span
     * @param end end of specified time span
     * @return map date of historic value -> historic value
     */
    Map<Date, BigDecimal> getHistoricValues(String id, Date start, Date end);

    /**
     * Sets historic value for specific index
     * @param id specified index id
     * @param date date of historic value
     * @param value historic value for given date
     */
    void setHistoricValue(String id, Date date, BigDecimal value);

    /**
     * Gets current values of all indexes
     * @return <code>Collection</code> of <code>Index</code>es with their current values
     */
    Collection<Index> getAllCurrentValues();

}
