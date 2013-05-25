package servlet;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Client")
public class ClientBean extends HttpServlet {

	private static final long serialVersionUID = -6948827418149135145L;
	
	private IndexDao indexDao = new IndexDaoImpl();
	
	List<String> indexes = new ArrayList<String>();
	List<String> testIndexes = new ArrayList<String>();
	
	public ClientBean()
	{
		for (Index index : indexDao.getAllCurrentValues())
		{
			
			indexes.add(index.getId());
		}
		
           
	}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{

		//tring c = request.getParameter("type");

		ClientBean cb = new ClientBean();
		
		request.setAttribute("myIndexes", cb.getMyIndexes(request));
		RequestDispatcher view = request.getRequestDispatcher("Client.jsp");
		view.forward(request, response); 
	}
	
	public List<String> getIndexes(){
		
	      return indexes;
	   }

	//
	public List<String> getTestIndexes(){
	      return testIndexes;
	   }
	
	public List<String> getMyIndexes(HttpServletRequest request){
		
		List<String> myIndexes = new ArrayList<String>();
		
		for (Index index : indexDao.getAllCurrentValues())
		{

			if(request.isUserInRole(index.getId()))
			{
				myIndexes.add(index.getId());
			}
		}

		return myIndexes;
		
	}
}
