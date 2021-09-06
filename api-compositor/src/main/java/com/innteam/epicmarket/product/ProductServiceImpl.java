package com.innteam.epicmarket.product;

import java.util.Collections;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProductsList() {
        Product mockitoProduct = new Product("Mockito product",
                "https://mir-s3-cdn-cf.behance.net/projects/202/8bd59575276459.Y3JvcCw5OTksNzgyLDAsMA.jpg",
                23.5d, 5);
        return Collections.singletonList(mockitoProduct);
    }

    @Override
    public List<Product> getDeals() {
        Product mockitoProduct = new Product("Mockito sale product",
                "https://img.freepik.com/free-psd/creative-valentines-sale-mockup_23-2148022447.jpg?size=338&ext=jpg",
                15.5d, 4);
        return Collections.singletonList(mockitoProduct);
    }
}
