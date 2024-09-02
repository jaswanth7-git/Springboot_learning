package com.products.product.Controllers;
import com.products.product.Models.User;
import com.products.product.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public String auth(@RequestBody User p){
        return userService.auth(p);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User p){
        userService.registerUser(p);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
