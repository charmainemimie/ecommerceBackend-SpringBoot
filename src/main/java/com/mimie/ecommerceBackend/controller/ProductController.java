package com.mimie.ecommerceBackend.controller;

import com.mimie.ecommerceBackend.model.Product;
import com.mimie.ecommerceBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

@Autowired
    private ProductService service;
    @RequestMapping("/")
    public String greet(){
        return "hi welcome to my shop";
    }

    @GetMapping("/products")
    public List<Product>getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProduct( id);
    }

//    @PostMapping("/products")
//    public List<Product>getAllProducts() {
//        return service.getAllProducts();
//    }
}
