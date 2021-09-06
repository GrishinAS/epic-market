package com.innteam.epicmarket.rest;

import com.innteam.epicmarket.product.Product;
import com.innteam.epicmarket.product.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductInfoRest {

    private final ProductService productService;

    public ProductInfoRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProductsList() {
        return productService.getProductsList();
    }

    @GetMapping("/deals")
    public List<Product> getDeals() {
        return productService.getDeals();
    }
}
