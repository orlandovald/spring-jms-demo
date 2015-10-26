package com.ovstuff.springjmsdemo.web;

import com.ovstuff.springjmsdemo.jms.JmsSender;
import com.ovstuff.springjmsdemo.model.MessageObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by ovaldez on 10/24/15.
 */
@RestController
public class SpringJmsDemoController {

    private static final Logger log = LoggerFactory.getLogger(SpringJmsDemoController.class);

    @Autowired
    JmsSender jmsSender;

    @RequestMapping(value = "/ping/pong", method = RequestMethod.GET)
    public String ping() {
        return "ping";
    }

    @RequestMapping(value = "/jms/put", method = RequestMethod.GET)
    public MessageObject putMessage() {

        String uuid = UUID.randomUUID().toString();

        MessageObject msgObj = new MessageObject();
        msgObj.setUuid(uuid);
        msgObj.setPrice(15.43);
        msgObj.setQuantity(10001L);
        msgObj.setTimeStamp(Calendar.getInstance());

        jmsSender.sendMessage(msgObj);

        return msgObj;
    }

}
