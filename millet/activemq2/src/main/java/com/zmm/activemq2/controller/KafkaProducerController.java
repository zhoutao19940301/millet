package com.zmm.activemq2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/10/31
 **/
@RestController
@RequestMapping("active")
public class KafkaProducerController {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queue;

    @GetMapping("send")
    public String send(String msg){
        jmsMessagingTemplate.convertAndSend("test_queue", msg);
        return "success";
    }

}
