package com.products.product.Controllers;

import com.products.product.Models.Product;
import com.products.product.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public String setProducts(@RequestBody Product p) {
        return productService.setProducts(p);
    }

    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String delProductbyId(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product p) {
        return productService.updateProduct(id, p);
    }
    @GetMapping("/search/{queryparam}")
    public ResponseEntity<List<Product>>searchProducts(@PathVariable String queryparam){
        List<Product>resultproducts = productService.searchProducts(queryparam);
        return new ResponseEntity<>(resultproducts, HttpStatus.OK);
    }
}