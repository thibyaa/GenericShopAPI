package com.example.GenericShopAPI.services;

import com.example.GenericShopAPI.models.Shop;
import com.example.GenericShopAPI.models.User;
import com.example.GenericShopAPI.models.UserDTO;
import com.example.GenericShopAPI.repositories.ShopRepository;
import com.example.GenericShopAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ShopRepository shopRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User createNewUser(UserDTO userDTO) {
        Shop shop = shopRepository.findById(userDTO.getShopId()).get();
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getBirthday(), shop);
       return userRepository.save(user);
    }

//    public User updateUser(Long id, UserDTO userDTO) {
//    User updatedUser = userRepository.findById(id).get();
//    updatedUser = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getBirthday(), shop)
//    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
