package com.example.zara.Repository;

import com.example.zara.Model.Price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//********************************************************//
//*********************Price Repository*******************//
//********************************************************//
@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    
}
