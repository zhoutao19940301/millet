package com.zmm.activemq2;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.jms.Queue;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class Activemq2Application {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(Activemq2Application.class);
        ConfigurableApplicationContext run = application.run(args);
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Talkweb-Boot is running! Access URLs:\n\t" +
                "swagger-ui: \t\thttp://127.0.0.1:" + port + path + "/swagger-ui.html\n\t" +
                "Doc: \t\thttp://" + "127.0.0.1:"  + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }

    @Bean
    Queue queue() {
        return new ActiveMQQueue("zt-queue");
    }


}
