package com.oauth.service;

import com.oauth.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private List<Product> list = new ArrayList<>();

    public Product add(Product product){
        product.setProductId(UUID.randomUUID().toString());

//        list.add(product);

        list.add(
                Product.builder()
                        .name("Car")
                        .productId("1")
                        .description("hello 1 23 ")
                        .price("20000").build());

        return product;
    }

    public List<Product> getAll(){
        return list;
    }

    public void delete(String id){

        list.removeIf(product -> product.getProductId().equals(id));
    }
}
