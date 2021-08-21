package com.example.zara.Controller;
import java.util.List;

import com.example.zara.Model.Brand;
import com.example.zara.Sevice.Brand.IBrandService;

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
@RequestMapping("/api/brand")
public class BrandRestController {
    @Autowired
    private IBrandService brandService;
    @GetMapping
    public ResponseEntity<List<Brand>> getAll(){
        List<Brand> brandList = brandService.getAll();
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }
    @PostMapping
    public void save(@RequestBody Brand brand){
        brandService.save(brand);
    }
    @PutMapping
    public void update(@RequestBody Brand brand){
        brandService.save(brand);
    }
	
    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") long id) {
        brandService.delete(id);
    } 
}
