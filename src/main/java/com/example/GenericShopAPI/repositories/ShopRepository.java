package com.example.GenericShopAPI.repositories;
import com.example.GenericShopAPI.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
