package com.example.GenericShopAPI.models;
import java.time.LocalDate;

public class UserDTO {

    private String username;
    private String password;
    private String email;
    private LocalDate birthday;
    private Long shopId;

    public UserDTO(String username, String password, String email, LocalDate birthday, Long shopId){
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.shopId = shopId;

    }

    public UserDTO(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
