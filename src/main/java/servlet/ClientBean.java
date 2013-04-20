package servlet;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import server.DemoInitializer;

public class ClientBean implements java.io.Serializable {

	private static final long serialVersionUID = -6948827418149135145L;
	
	private IndexDao indexDao = new IndexDaoImpl();
	
	List<String> indexes = new ArrayList<String>();
	List<String> testIndexes = new ArrayList<String>();
	
	public ClientBean()
	{
		new DemoInitializer().initialize();
		
		for (Index index : indexDao.getAllCurrentValues())
		{
			
			indexes.add(index.getId());
		}
		
		testIndexes.add("indA");
		testIndexes.add("indb");
		testIndexes.add("indc");
		testIndexes.add("indd");
		
           
	}
	
	public List<String> getIndexes(){
		
	      return indexes;
	   }

	public List<String> getTestIndexes(){
	      return testIndexes;
	   }
	
	public List<String> getMyIndexes(HttpServletRequest request){
		
		List<String> myIndexes = new ArrayList<String>();
		
		myIndexes.add("start");
		for (Index index : indexDao.getAllCurrentValues())
		{
			myIndexes.add(index.getId());

			if(request.isUserInRole(index.getId()))
			{
				myIndexes.add(index.getId());
			}
				myIndexes.add("false");
		}
		myIndexes.add("end");
		return myIndexes;
		
	}
}
