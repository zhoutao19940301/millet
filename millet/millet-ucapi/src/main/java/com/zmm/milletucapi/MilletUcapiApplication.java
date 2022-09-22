package com.zmm.milletucapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
@EnableSwagger2
@MapperScan(basePackages = {"com.zmm.milletucapi.dao","com.zmm.commonutils.dao"})
public class MilletUcapiApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(MilletUcapiApplication.class);
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

}
