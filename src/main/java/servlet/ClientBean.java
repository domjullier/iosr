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
		
		
		testIndexes.add("indA");
		testIndexes.add("indb");
		testIndexes.add("indc");
		testIndexes.add("indd");
		
           
	}
	
	public List<String> getIndexes(){
		
		indexes.add("x");
		for (Index index : indexDao.getAllCurrentValues())
		{
			
			indexes.add(index.getId());
		}
		indexes.add("endx");
		
	      return indexes;
	   }

	public List<String> getTestIndexes(){
	      return testIndexes;
	   }
	
	public List<String> getMyIndexes(HttpServletRequest request){
		
		List<String> myIndexes = new ArrayList<String>();
		
		for (Index index : indexDao.getAllCurrentValues())
		{
			if(request.isUserInRole(index.getId()))
				myIndexes.add(index.getId());
		}
		
		return myIndexes;
		
	}
}
