package com.products.product.Controllers;

import com.products.product.Beans.AddToCart;
import com.products.product.Models.Product;
import com.products.product.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody AddToCart a){
        Integer id = a.getId();
        String useremail = a.getEmail();
        System.out.println("id"+id+"user email"+useremail);
        return new ResponseEntity<>(cartService.addtocart(id,useremail), HttpStatus.OK);
    }
    @GetMapping("/get/{useremail}")
    public ResponseEntity<List<Product>>getFromCart(@PathVariable String useremail){
        return new ResponseEntity<>(cartService.getFromCart(useremail),HttpStatus.OK);
    }
}
