package com.example.zara.Repository;

import com.example.zara.Model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//********************************************************//
//********************Prudct Repository*******************//
//********************************************************//
@Repository
public interface IProductRepo extends JpaRepository<Product, Long>{
    
}
