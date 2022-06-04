package com.innteam.epicmarket.logistic.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LogisticApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(LogisticApiApplication.class, args);
  }
}
