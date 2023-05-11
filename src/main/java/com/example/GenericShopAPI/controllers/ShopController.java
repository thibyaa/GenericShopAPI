package com.example.GenericShopAPI.controllers;

import com.example.GenericShopAPI.models.Shop;
import com.example.GenericShopAPI.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    ShopService shopService;

//    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Shop> getShopDetails(@PathVariable Long id){
        return new ResponseEntity<>(shopService.shopDetails(id), HttpStatus.OK);
    }
}
