package com.innteam.epicmarket.buyer.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BuyerApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(BuyerApiApplication.class, args);
  }
}
