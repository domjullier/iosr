package server;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Server")
public class Server extends HttpServlet {

    private IndexDao indexDao = new IndexDaoImpl();

    public Server() {
        new DemoInitializer().initialize();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        for (Index index : indexDao.getAllCurrentValues())
            out.write(index.getId() + " " + index.getCurrentValue() + " " + index.getCurrency() + "<br/>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
