package servlet;

import java.math.BigDecimal;
import java.util.List;
import model.Index;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



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
		
		cc.indexes.add(index);
		
		
		
		boolean containsTestIndex = false;
		
		//get all only indexes for user with role Test
		MockRequestObject mo = new MockRequestObject();
		
		List<String> result1 = cc.getMyIndexes(mo);
		
		
		for (String index1 : result1)
		{
			
			if (index1.contentEquals("Test"))
			{
				containsTestIndex = true;
			}
				
		}
		Assert.assertEquals(containsTestIndex, true);
		
		
		containsTestIndex = false;
		//get all only indexes for user with role Test
		
		
		for (String index2 : result1)
		{
			
			if (index2.contentEquals("Testxxxx"))
			{
				containsTestIndex = true;
			}
				
		}
		Assert.assertEquals(containsTestIndex, false);
		
	}

	
}
