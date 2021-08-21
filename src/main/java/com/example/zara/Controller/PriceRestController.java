package com.example.zara.Controller;
import java.util.List;

import com.example.zara.Model.Price;
import com.example.zara.Sevice.Price.IPriceService;

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
@RequestMapping("/api/price")
public class PriceRestController {
    @Autowired
    private IPriceService priceService;
    @GetMapping
    public ResponseEntity<List<Price>> getAll(){
        List<Price> priceList = priceService.getAll();
        return new ResponseEntity<>(priceList, HttpStatus.OK);
    }
    @PostMapping
    public void save(@RequestBody Price price){
        priceService.save(price);
    }
    @PutMapping
    public void update(@RequestBody Price price){
        priceService.save(price);
    }
	
    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") long id) {
        priceService.delete(id);
    } 
    
}
