
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Index;


@WebServlet("/ClientSend")
public class ClientSend extends HttpServlet {

	private static final long serialVersionUID = -8314035702649252239L;

	//test
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName = "java:/queue/test")
	private Queue queue;
	
	@Resource(mappedName = "java:/topic/test")
	private Topic topic;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		
		//req.isUserInRole("guest");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Connection connection = null;
		
		try {
		    Destination destination;
		    //if (req.getParameterMap().keySet().contains("topic")) {
		    //    destination = topic;
		   // } else {
		        destination = queue;
		    //}
		    out.write("<H2>Sending messages to <em>" + destination + "</em></H2>");
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(destination);
			connection.start();
			
			Index index = new Index();
			
			index.setId(req.getParameter("index"));
			index.setCurrentValue(new BigDecimal(req.getParameter("Value")));
	
			ObjectMessage mymsg = session.createObjectMessage(index);
			
			messageProducer.send(mymsg);
			
			out.write("Sent update for index: " + index.getId() + ". New Value is: " + index.getCurrentValue() + ".</br>");


		} catch (JMSException e) {
			e.printStackTrace();
			out.write("<h2>A problem occurred during the delivery of this message</h2>");
			out.write("</br>");
			out.write("<p><i>Go your the JBoss Application Server console or Server log to see the error stack trace</i></p>");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				out.close();
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
