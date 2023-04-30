package com.example.GenericShopAPI.services;

import com.example.GenericShopAPI.models.Shop;
import com.example.GenericShopAPI.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    
    @Autowired
    ShopRepository shopRepository;


    public Shop shopDetails(Long id) {
        return shopRepository.findById(id).get();
    }

}
