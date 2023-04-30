package com.example.GenericShopAPI.repositories;
import com.example.GenericShopAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
