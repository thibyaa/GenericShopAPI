package com.example.GenericShopAPI.controllers;

import com.example.GenericShopAPI.models.User;
import com.example.GenericShopAPI.models.UserDTO;
import com.example.GenericShopAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

//    INDEX
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

//    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

//    CREATE
    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createNewUser(userDTO), HttpStatus.CREATED);
    }

//    UPDATE
//    @PutMapping(value = "{/id}")
//    public ResponseEntity<User> updateUser(@RequestParam String username, @PathVariable Long id){
//        return new ResponseEntity<>(userService.updateUser(id, userDTO), HttpStatus.OK);
//    }

//    DESTROY
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User data deleted", HttpStatus.OK);
    }

//    MAGIC LOGIN
//    @PostMapping
//    public ResponseEntity<String> logInUser(@RequestParam String username, @RequestParam String password){
//        return new ResponseEntity<>(userService.checkValidUser(username, password), HttpStatus.ACCEPTED);
//    }

//    @PostMapping
//    public ResponseEntity<String> logInUser(@RequestParam String username){
//        return new ResponseEntity<>(userService.checkValidUser(username), HttpStatus.ACCEPTED);
//    }

}
