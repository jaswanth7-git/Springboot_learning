package com.products.product.Controllers;

import com.products.product.Models.Product;
import com.products.product.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public List<Product> getProducts() {
        return productService.getproducts();
    }
    @PostMapping
    public String setProducts(@RequestBody Product p){
       return productService.setProducts(p);
    }
    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable Integer id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public String delProductbyId(@PathVariable Integer id){
        return productService.deleteProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id,@RequestBody Product p){
        return productService.updateProduct(id,p);
    }
}
