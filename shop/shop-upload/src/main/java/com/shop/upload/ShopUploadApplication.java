package com.shop.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShopUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopUploadApplication.class);
    }

}
