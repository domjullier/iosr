package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Index implements Serializable {

	private static final long serialVersionUID = 2217758364436385895L;

	private String id;
	private BigDecimal currentValue;
	private Map<Date, BigDecimal> historicValues;
	private String currency;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}

	public void setHistoricValues(Map<Date, BigDecimal> historicValues) {
		this.historicValues = historicValues;
	}

	public Map<Date, BigDecimal> getHistoricValues() {
		return historicValues;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

}
