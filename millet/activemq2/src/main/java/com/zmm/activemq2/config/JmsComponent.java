package com.zmm.activemq2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * JmsComponent
 *
 * @author zhoutao21342@talkweb.com.cn
 * @date 2022/10/9
 * @apiNote
 */
@Component
public class JmsComponent {

    //消息发送模板
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queue;

    //发送消息
    public void send(String message) {
        jmsMessagingTemplate.convertAndSend(queue,message);
    }

    //接收消息
    @JmsListener(destination = "zt-queue")
    public void receive(String message) {
        System.out.println("message:" + message);
    }

}
