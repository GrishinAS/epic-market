package com.innteam.epicmarket.config;

import com.innteam.epicmarket.product.ProductService;
import com.innteam.epicmarket.product.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }
}
