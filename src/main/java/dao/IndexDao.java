package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import model.Index;

public interface IndexDao extends GenericDao<Index, String> {
	
	Map<Date, BigDecimal> getValuesHistory(String id, Date start, Date end);
	
	BigDecimal getCurrentValue(String id);
	
	void setValue(String id, Date date, BigDecimal value);
	

}
