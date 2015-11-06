package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mangofactory.swagger.plugin.EnableSwagger;

@SpringBootApplication
@EnableSwagger
public class BrokerPOSPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrokerPOSPlanApplication.class, args);
    }
    
   
}
