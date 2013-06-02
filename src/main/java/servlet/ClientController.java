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

/**
 * Handles Client's main page request
 */
@WebServlet("/Client")
public class ClientController extends HttpServlet {

	private static final long serialVersionUID = -6948827418149135145L;
	
	private IndexDao indexDao = new IndexDaoImpl();
	
	List<Index> indexes = new ArrayList<Index>();
	List<String> testIndexes = new ArrayList<String>();

    /**
     * Class constructor
     */
	public ClientController()
	{
		for (Index index : indexDao.getAllCurrentValues())
		{
			
			indexes.add(index);
		}
		
           
	}

    /**
     * Handles <code>GET</code> request
     * @param request request from client
     * @param response response to client
     * @throws IOException
     * @throws ServletException
     */
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{

		ClientController cb = new ClientController();
		
		request.setAttribute("myIndexes", cb.getMyIndexes(request));
		RequestDispatcher view = request.getRequestDispatcher("Client.jsp");
		view.forward(request, response); 
	}
	
	//public List<Index> getIndexes(){
		
	//      return indexes;
	//   }

    /**
     * Returns indexes of the user
     * @param request request from client
     * @return a <code>List</code> of <code>Strings</code> representing indexes
     */
	public List<String> getMyIndexes(HttpServletRequest request){
		
		List<String> myIndexes = new ArrayList<String>();
		
		for (Index index : indexes)
		{

			if(request.isUserInRole(index.getId()))
			{
				myIndexes.add(index.getId());
			}
		}

		return myIndexes;
		
	}
}
