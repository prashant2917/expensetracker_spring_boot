package com.pocketapi.expensetracker.controller;

import com.pocketapi.expensetracker.model.Message;
import com.pocketapi.expensetracker.model.Product;
import com.pocketapi.expensetracker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product-api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity getAllProducts()
    {
        List<Product> products = productService.getAllProducts();
        if(products.isEmpty()) {

            return  new ResponseEntity(new Message("No products found"), HttpStatus.OK);
        }
        return new ResponseEntity(products,HttpStatus.OK);
    }
    @PostMapping(value="/add-product")
    public ResponseEntity addUser(@RequestBody Product product)
    {
        productService.addUser(product);
        return new ResponseEntity(new Message("Product "+product.getProductName() +"  Added Successfully"),HttpStatus.CREATED);
    }
}