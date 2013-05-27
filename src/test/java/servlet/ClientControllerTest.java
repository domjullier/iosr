package servlet;

import java.math.BigDecimal;
import java.util.List;

import model.Index;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dao.GenericDaoImpl;

public class ClientControllerTest {

	@BeforeMethod
	protected void setUp() {
		
	}
	
	@Test
	public void controllerTest() {
		ClientController cc = new ClientController();
		
		Index index = new Index();
		index.setId("Test");
		index.setCurrentValue(new BigDecimal("11.11"));
		index.setCurrency("PLN");
		
		cc.indexes.add(index.getId());
		
		//get all indexes, added Test must be there
		List<String> result = cc.getIndexes();
		
		boolean containsTestIndex = false;
		
		for (String indexTest : result)
		{
			if (indexTest.contentEquals("Test"))
			{
				containsTestIndex = true;
			}
				
		}
		
		Assert.assertEquals(containsTestIndex, true);
		
		
		//get all only indexex for user with role Test
		
		
		
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getMyIndexes() {
		throw new RuntimeException("Test not implemented");
	}
}
