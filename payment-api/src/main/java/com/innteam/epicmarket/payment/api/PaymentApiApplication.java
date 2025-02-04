package com.innteam.epicmarket.payment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaymentApiApplication.class, args);
  }
}
