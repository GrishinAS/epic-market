package com.innteam.epicmarket.product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsList();

    List<Product> getDeals();
}
