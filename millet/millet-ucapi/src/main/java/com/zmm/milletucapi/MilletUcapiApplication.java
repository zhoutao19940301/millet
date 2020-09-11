package com.zmm.milletucapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.zmm.milletucapi.dao","com.zmm.commonutils.dao"})
public class MilletUcapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilletUcapiApplication.class, args);
    }

}
