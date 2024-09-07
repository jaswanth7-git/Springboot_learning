package com.products.product.Services;

import com.products.product.Models.Cart;
import com.products.product.Models.Product;
import com.products.product.Models.User;
import com.products.product.Repos.CartRepo;
import com.products.product.Repos.ProductRepo;
import com.products.product.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CartRepo cartRepo;
    public String addtocart(Integer id, String useremail) {
        Product selected_product = productRepo.findById(id).get();
        User selected_user = userRepo.findById(useremail).get();
        Cart cart_final = new Cart(selected_user,selected_product,id);
        cartRepo.save(cart_final);
        return "{\n    \"email\" : \""+useremail+"\",\n    \"status\" : \"success\"\n}";
    }
}
