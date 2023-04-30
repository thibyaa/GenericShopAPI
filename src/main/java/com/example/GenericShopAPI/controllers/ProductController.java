package com.example.GenericShopAPI.controllers;

import com.example.GenericShopAPI.models.Product;
import com.example.GenericShopAPI.models.ProductDTO;
import com.example.GenericShopAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

//    INDEX
    @GetMapping
    public ResponseEntity<List<Product>> showAllProducts(){
        return new ResponseEntity<>(productService.displayAllProducts(), HttpStatus.OK);
    }

//    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> showProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }
//    CREATE
    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.addNewProduct(productDTO), HttpStatus.CREATED);
    }

//    UPDATE
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Product> updateProductPrice(@PathVariable Long id, @RequestParam double price){
        return new ResponseEntity<>(productService.changeProductPrice(id, price), HttpStatus.OK);
    }

//    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("product has been removed", HttpStatus.OK);
    }
}
