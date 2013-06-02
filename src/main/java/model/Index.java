package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Index model implementation
 */
public class Index implements Serializable {

	private static final long serialVersionUID = 2217758364436385895L;

	private String id;
	private BigDecimal currentValue;
	private Map<Date, BigDecimal> historicValues = new HashMap<Date, BigDecimal>();
	private String currency;

    /**
     * Sets id for index
     * @param id index id
     */
    public void setId(String id) {
		this.id = id;
	}

    /**
     * Gets index id
     * @return index id
     */
	public String getId() {
		return id;
	}

    /**
     * Gets index current value
     * @return index current value
     */
	public BigDecimal getCurrentValue() {
		return currentValue;
	}

    /**
     * Sets index current value
     * @param currentValue index current value
     */
	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
        historicValues.put(new Date(), currentValue);
	}

    /**
     * Sets index historic values
     * @param historicValues map date of historic value -> historic value
     */
    public void setHistoricValues(Map<Date, BigDecimal> historicValues) {
		this.historicValues = historicValues;
	}

    /**
     * Sets index historic values
     * @return map date of historic value -> historic value
     */
    public Map<Date, BigDecimal> getHistoricValues() {
		return historicValues;
	}

    /**
     * Sets index currency
     * @param currency index currency
     */
    public void setCurrency(String currency) {
		this.currency = currency;
	}

    /**
     * Gets index currency
     * @return index currency
     */
    public String getCurrency() {
		return currency;
	}

}
