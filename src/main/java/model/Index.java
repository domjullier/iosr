package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Index implements Serializable {
	
	private static final long serialVersionUID = 2217758364436385895L;
	
	private String id;
	private Map<Date, BigDecimal> values;
	private String currency;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setValues(Map<Date, BigDecimal> values) {
		this.values = values;
	}

	public Map<Date, BigDecimal> getValues() {
		return values;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

}
