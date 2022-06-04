package com.innteam.epicmarket.seller.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SellerApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SellerApiApplication.class, args);
  }
}
