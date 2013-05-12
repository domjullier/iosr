package server;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.logging.Logger;


@MessageDriven(
        name = "UpdateReceiver",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test")
        })


public class UpdateReceiver implements MessageListener {

    private final static Logger LOGGER = Logger.getLogger(UpdateReceiver.class
            .toString());
    final IndexDao indexDao = new IndexDaoImpl();

    public void onMessage(Message rcvMessage) {


        try {
            if (rcvMessage instanceof ObjectMessage) {
                Index index = (Index) ((ObjectMessage) rcvMessage).getObject();

                LOGGER.info("Received Message from queue: " + index.getId());

                indexDao.setCurrentValue(index.getId(), index.getCurrentValue());
            } else {
                LOGGER.warning("Message of wrong type: "
                        + rcvMessage.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

}
