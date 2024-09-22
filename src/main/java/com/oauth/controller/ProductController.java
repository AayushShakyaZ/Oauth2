package com.oauth.controller;

import com.oauth.model.Product;
import com.oauth.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    public Product createProduct(@RequestBody Product product) {
        return productService.add(product);
    }

    public List<Product> getList(){

        return productService.getAll();
    }

    public void deleteProduct(@RequestParam String id){
        productService.delete(id);
    }

}
