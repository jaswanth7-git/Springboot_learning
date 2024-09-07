package com.products.product.Repos;

import com.products.product.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart , Long> {

}
