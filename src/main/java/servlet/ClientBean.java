package servlet;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import java.util.List;

public class ClientBean implements java.io.Serializable {

	private static final long serialVersionUID = -6948827418149135145L;
	
	private IndexDao indexDao = new IndexDaoImpl();
	
	List<String> indexes;
	
	public ClientBean()
	{
		
		for (Index index : indexDao.getAllCurrentValues())
		{
			indexes.add(index.getId());
		}
           
	}
	
	public List<String> getIndexes(){
	      return indexes;
	   }

}
