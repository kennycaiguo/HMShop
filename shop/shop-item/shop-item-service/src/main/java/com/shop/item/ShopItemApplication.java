package com.shop.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.shop.item.mapper")
public class ShopItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopItemApplication.class);
    }

}
