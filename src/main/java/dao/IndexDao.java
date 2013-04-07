package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import model.Index;

public interface IndexDao extends GenericDao<Index, String> {

	BigDecimal getCurrentValue(String id);

	void setCurrentValue(String id, BigDecimal value);

	Map<Date, BigDecimal> getHistoricValues(String id, Date start, Date end);

	void setHistoricValue(String id, Date date, BigDecimal value);

}
