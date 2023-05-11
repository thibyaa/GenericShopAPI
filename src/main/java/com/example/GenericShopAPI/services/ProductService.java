package com.example.GenericShopAPI.services;

import com.example.GenericShopAPI.models.Product;
import com.example.GenericShopAPI.models.ProductDTO;
import com.example.GenericShopAPI.models.Shop;
import com.example.GenericShopAPI.repositories.ProductRepository;
import com.example.GenericShopAPI.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShopRepository shopRepository;

    public List<Product> displayAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product addNewProduct(ProductDTO productDTO) {
        Shop shop = shopRepository.findById(productDTO.getShopId()).get();
        Product product = new Product(productDTO.getProductName(), productDTO.getProductPrice(), shop);
//        shop.updateTill(product);
//        shopRepository.save(shop);
        return productRepository.save(product);
    }

    public Product changeProductPrice(Long id, double updatedPrice){
        Product product = productRepository.findById(id).get();
        product.setProductPrice(updatedPrice);
        return productRepository.save(product);
        // need to add a part to this method which sorts out the till
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
