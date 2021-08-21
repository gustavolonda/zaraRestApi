package com.example.zara.Controller;


import java.util.List;

import com.example.zara.Model.Product;
import com.example.zara.Sevice.Product.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gustavo Londa
 */
@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> productList = productService.getAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @PostMapping
    public void save(@RequestBody Product product){
        productService.save(product);
    }
    @PutMapping
    public void update(@RequestBody Product product){
        productService.save(product);
    }
	
    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") long id) {
        productService.delete(id);
    } 
}
