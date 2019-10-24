package com.shop.item.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ShopRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopRegistryApplication.class);
    }

}
