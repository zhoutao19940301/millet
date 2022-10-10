package com.zmm.activemq2;

import com.zmm.activemq2.config.JmsComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Activemq2ApplicationTests {

    @Autowired
    JmsComponent jmsComponent;

    @Test
    void contextLoads() {
        jmsComponent.send("消息红红火火恍恍惚惚");
    }

}
