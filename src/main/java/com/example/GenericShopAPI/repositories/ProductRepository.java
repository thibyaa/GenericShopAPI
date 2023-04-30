package com.example.GenericShopAPI.repositories;
import com.example.GenericShopAPI.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
