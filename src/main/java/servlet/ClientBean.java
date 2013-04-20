package servlet;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import java.util.ArrayList;
import java.util.List;

public class ClientBean implements java.io.Serializable {

	private static final long serialVersionUID = -6948827418149135145L;
	
	private IndexDao indexDao = new IndexDaoImpl();
	
	List<String> indexes = new ArrayList<String>();
	List<String> testIndexes = new ArrayList<String>();
	
	public ClientBean()
	{
		
		
		
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
	
	public List<String> getMyIndexes(String userid){
		
		testIndexes.add(userid);
		return testIndexes;
		
	}
}
