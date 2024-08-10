package com.products.product.Services;

import com.products.product.Models.Product;
import com.products.product.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public List<Product> getproducts() {
        return productRepo.findAll();
    }
    public String setProducts(Product s){

        if(productRepo.existsById(s.getId())){
            return "{'message' : product already saved}";
        }

        productRepo.save(s);
        return "{'message' : records saved}";
    }

    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }
}
