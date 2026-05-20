package com.mimie.ecommerceBackend.controller;

import com.mimie.ecommerceBackend.model.Product;
import com.mimie.ecommerceBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//    @PostMapping("/products")
//    public List<Product>getAllProducts() {
//        return service.getAllProducts();
//    }
}
