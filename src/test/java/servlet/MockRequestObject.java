package servlet;

public class MockRequestObject {
	
	public boolean isUserInRole(String id)
	{
		if (id.equals("Test"))
			return true;
		
		else
			return false;
		
	}

}
