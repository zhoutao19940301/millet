package com.zmm.milletkafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/10/31
 **/
@RestController
@RequestMapping("kafka")
public class KafkaProducerController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("send")
    public String send(String msg){
        kafkaTemplate.send("test_topic", msg);
        return "success";
    }

}
