package dao;

import model.Index;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 18.04.13
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class IndexDaoImplTest {

    private IndexDao indexDao;

    @BeforeMethod
    protected void setUp() {
        indexDao = new IndexDaoImpl();
    }

    @Test
    public void testOperations() {

        Index index = new Index();
        index.setId("WIG");
        index.setCurrentValue(new BigDecimal("1515.15"));
        index.setCurrency("PLN");

        Index index2 = new Index();
        index2.setId("WIG20");
        index2.setCurrentValue(new BigDecimal("888.88"));
        index2.setCurrency("PLN");

        BigDecimal newCurrentValue = new BigDecimal("1616.16");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013, Calendar.APRIL, 1);
        Date historicDate = calendar.getTime();
        BigDecimal historicValue = new BigDecimal("1414.14");

        indexDao.create(index);

        BigDecimal readCurrentValue = indexDao.getCurrentValue(index.getId());

        Assert.assertEquals(readCurrentValue, index.getCurrentValue());

        indexDao.setCurrentValue(index.getId(), newCurrentValue);

        readCurrentValue = indexDao.getCurrentValue(index.getId());

        Assert.assertEquals(readCurrentValue, newCurrentValue);

        indexDao.create(index2);

        Collection<Index> allCurrentValuesCollection = indexDao.getAllCurrentValues();

        Assert.assertEquals(allCurrentValuesCollection.size(), 2);

        Index[] allCurrentValues = new Index[2];

        for (Index value : allCurrentValuesCollection) {
            if (index.getId().equals(value.getId()))
                allCurrentValues[0] = value;
            if (index2.getId().equals(value.getId()))
                allCurrentValues[1] = value;
        }

        Assert.assertEquals(allCurrentValuesCollection.size(), 2);

        Assert.assertEquals(allCurrentValues[0].getId(), index.getId());
        Assert.assertEquals(allCurrentValues[0].getCurrentValue(), newCurrentValue);
        Assert.assertEquals(allCurrentValues[0].getCurrency(), index.getCurrency());

        Assert.assertEquals(allCurrentValues[1].getId(), index2.getId());
        Assert.assertEquals(allCurrentValues[1].getCurrentValue(), index2.getCurrentValue());
        Assert.assertEquals(allCurrentValues[1].getCurrency(), index2.getCurrency());

    }
}
