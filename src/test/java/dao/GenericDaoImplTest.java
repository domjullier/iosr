package dao;

import java.math.BigDecimal;

import model.Index;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GenericDaoImplTest {

	private GenericDao<Index, String> genericDao;

	@BeforeMethod
	protected void setUp() {
		genericDao = new GenericDaoImpl<Index, String>();
	}

	@Test
	public void testCRUD() {
		Index index = new Index();
		index.setId("WIG");
		index.setCurrentValue(new BigDecimal("1515.15"));
		index.setCurrency("PLN");

		Index index2 = new Index();
		index2.setId("WIG");
		index2.setCurrentValue(new BigDecimal("888.88"));
		index2.setCurrency("PLN");

		genericDao.create(index);

		Index readIndex = genericDao.read(index.getId());

		Assert.assertEquals(readIndex.getId(), index.getId());
		Assert.assertEquals(readIndex.getCurrentValue(),
				index.getCurrentValue());
		Assert.assertEquals(readIndex.getCurrency(), index.getCurrency());

		genericDao.update(index2);

		readIndex = genericDao.read(index.getId());

		Assert.assertEquals(readIndex.getId(), index2.getId());
		Assert.assertEquals(readIndex.getCurrentValue(),
				index2.getCurrentValue());
		Assert.assertEquals(readIndex.getCurrency(), index2.getCurrency());

		genericDao.delete(index);

		readIndex = genericDao.read(index.getId());

		Assert.assertNull(readIndex);
	}

}
