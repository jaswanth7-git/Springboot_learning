package com.products.product.Repos;

import com.products.product.Models.Cart;
import com.products.product.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart , Long> {
    @Query("SELECT c FROM Cart c WHERE c.user.email = :email")
    List<Cart> getCartProductsByUserId(String email);
}
