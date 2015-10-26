package com.ovstuff.springjmsdemo.mdp;

import com.ovstuff.springjmsdemo.model.MessageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Created by ovaldez on 10/25/15.
 */
public class MdpSample {

    private static final Logger log = LoggerFactory.getLogger(MdpSample.class);

    public void handleMessage(ObjectMessage message) throws JMSException, InterruptedException {
        MessageObject msg = (MessageObject)message.getObject();

        log.debug("Message received with type = " + message.getStringProperty("MessageType"));
        Thread.sleep(5000);
        log.debug("Completed processing. Message contents:\n " + msg);
        message.acknowledge();

    }
}
