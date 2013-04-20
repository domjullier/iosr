package broker;

import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import model.Index;




@MessageDriven(
		   name="HelloWorldQueueMDB",
		   activationConfig = {
		      @ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		      @ActivationConfigProperty(propertyName="destination", propertyValue="queue/test")
		})



public class MDB_JMSReceiver implements MessageListener {
	
	private final static Logger LOGGER = Logger.getLogger(MDB_JMSReceiver.class
			.toString());
	
	public void onMessage(Message rcvMessage) {
		ObjectMessage msg = null;
		
		
		try {
			if (rcvMessage instanceof Message) {
				Index index = (Index) ((ObjectMessage)rcvMessage).getObject();
				
				LOGGER.info("Received Message from queue: " + index.getId());
			} else {
				LOGGER.warning("Message of wrong type: "
						+ rcvMessage.getClass().getName());
			}
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}