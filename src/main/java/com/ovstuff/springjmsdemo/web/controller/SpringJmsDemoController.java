package com.ovstuff.springjmsdemo.web.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by ovaldez on 10/24/15.
 */
@RestController
public class SpringJmsDemoController {

    private static final Logger log = LoggerFactory.getLogger(SpringJmsDemoController.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping(value = "/ping/pong", method = RequestMethod.GET)
    public String ping() {
        return "ping";
    }

    @RequestMapping(value = "/jms/put", method = RequestMethod.GET)
    public String putMessage() {

        String uuid = UUID.randomUUID().toString();

        jmsTemplate.convertAndSend("Message with id of " + uuid);
        log.debug("Message sent: " + uuid);

        return "Msg submitted: " + uuid;
    }

}
