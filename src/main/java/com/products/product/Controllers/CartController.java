package com.products.product.Controllers;

import com.products.product.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping
    public ResponseEntity<String> addToCart(@RequestBody Integer id, @RequestBody String useremail){
        return new ResponseEntity<>(cartService.addtocart(id,useremail), HttpStatus.OK);
    }
}
