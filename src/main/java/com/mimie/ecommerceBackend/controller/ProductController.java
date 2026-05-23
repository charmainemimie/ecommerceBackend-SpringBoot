package com.mimie.ecommerceBackend.controller;

import com.mimie.ecommerceBackend.model.Product;
import com.mimie.ecommerceBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

//    @GetMapping("/products")
//    public List<Product>getAllProducts() {
//        return service.getAllProducts();
//    }

    //use responseEntity to allow you to return a status code along with the response
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

//    @GetMapping("/product/{id}")
//    public Product getProduct(@PathVariable int id) {
//        return service.getProduct( id);
//    }

    //use responseEntity to allow you to return a status code along with the response
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){

        Product product=service.getProduct(id);

        if(product!=null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //add product
   @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
        try {
            System.out.println(product);
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get image
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product=service.getProduct(productId);

        byte[] imageFile=product.getImageDate();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);

    }
   }
