package com.ovstuff.springjmsdemo.jms;

import com.ovstuff.springjmsdemo.model.MessageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * Created by ovaldez on 10/25/15.
 */
public class JmsSender {

    private static final Logger log = LoggerFactory.getLogger(JmsSender.class);

    JmsTemplate jmsTemplate;

    public JmsSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(MessageObject msgObj) {

        MessagePostProcessor mpp = new MessagePostProcessor() {
            public Message postProcessMessage(Message msg) throws JMSException {
                msg.setStringProperty("MessageType", "Demo");
                return msg;
            }
        };

        jmsTemplate.convertAndSend(msgObj, mpp);
        log.debug("Message sent: " + msgObj.getUuid());

    }
}
