/*
package broker;

import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;




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
		TextMessage msg = null;
		
		
		try {
			if (rcvMessage instanceof TextMessage) {
				msg = (TextMessage) rcvMessage;
				LOGGER.info("Received Message from queue: " + msg.getText());
			} else {
				LOGGER.warning("Message of wrong type: "
						+ rcvMessage.getClass().getName());
			}
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
*/