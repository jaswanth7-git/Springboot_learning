package com.products.product.Repos;

import com.products.product.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query("SELECT p from Product p WHERE" +
            " p.name LIKE LOWER(CONCAT('%',:queryparam,'%'))")
    List<Product> getProductsByName(String queryparam);
}
