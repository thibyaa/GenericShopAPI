package com.example.GenericShopAPI.components;
import com.example.GenericShopAPI.models.Product;
import com.example.GenericShopAPI.models.Shop;
import com.example.GenericShopAPI.models.User;
import com.example.GenericShopAPI.repositories.ProductRepository;
import com.example.GenericShopAPI.repositories.ShopRepository;
import com.example.GenericShopAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        SHOP
        Shop shop = new Shop("Loshanth's Beauty Products ltd");
        shopRepository.save(shop);

//        USERS
        User kirushanth = new User("Kirushanth", "password", "kiru@kiru.com", LocalDate.of(1999, 06, 15), shop);
        User jaxsan = new User("Jaxsan", "password", "jaxsan@kiru.com", LocalDate.of(1999, 06, 22), shop);
        User nitharshan = new User("Nitharshan", "password", "nitharshan@kiru.com", LocalDate.of(1999, 07, 2), shop);
        userRepository.save(kirushanth);
        userRepository.save(jaxsan);
        userRepository.save(nitharshan);

//        PRODUCTS
        Product toner = new Product("Toner",19.99, shop);
        Product essence = new Product("Essence", 20.00, shop);
        Product serum = new Product("Serum", 24.99, shop);
        productRepository.save(toner);
        productRepository.save(essence);
        productRepository.save(serum);
        shop.updateTill(toner);
        shop.updateTill(essence);
        shop.updateTill(serum);
        shopRepository.save(shop);
    }
}
