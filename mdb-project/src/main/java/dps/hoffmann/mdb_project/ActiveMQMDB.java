package dps.hoffmann.mdb_project;

import javax.ejb.*;
import javax.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"
        ),
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "queue/XMLPublishQueuee"
        )
})
public class ActiveMQMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {

            if (message instanceof TextMessage) {

                System.out.println("Got Message "

                        + ((TextMessage) message).getText());

            }

        } catch (JMSException e) {

            e.printStackTrace();

        }

    }

}