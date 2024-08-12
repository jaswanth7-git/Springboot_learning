package com.products.product.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(){}

    @Id
    private String email;
    private String password;

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
}
