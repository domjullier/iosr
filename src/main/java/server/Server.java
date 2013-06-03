package server;

import dao.IndexDao;
import model.Index;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Enables web access for stored current values
 */
@WebServlet("/Server")
public class Server extends HttpServlet {

    private static final String CURRENT_INDEX_VALUES = "Current index values";
    @Inject private IndexDao indexDao;

    /**
     * Handles <code>GET</code> request
     * @param req request from entity interested in current values of all indexes
     * @param resp response to entity interested in current values of all indexes
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        StringBuffer out = new StringBuffer();
        out.append("<h2>" + CURRENT_INDEX_VALUES + "</h2><br/><br/>");
        for (Index index : indexDao.getAllCurrentValues())
            out.append(index.getId() + " " + index.getCurrentValue() + " " + index.getCurrency() + "<br/>");
        req.setAttribute("title", CURRENT_INDEX_VALUES);
        req.setAttribute("content", out.toString());
        RequestDispatcher view = req.getRequestDispatcher("Template.jsp");
        view.forward(req, resp);
    }

    /**
     * Handles <code>POST</code> request
     * @param req request from entity interested in current values of all indexes
     * @param resp response to entity interested in current values of all indexes
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
