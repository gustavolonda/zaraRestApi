package com.example.zara.Sevice.Price;

import com.example.zara.Model.Price;
import com.example.zara.Repository.IPriceRepo;
import com.example.zara.Sevice.Generic.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

//********************************************************//
//****************** Price Service ***********************//
//********************************************************//

@Service
public class PriceServiceImpl extends GenericServiceImpl<Price, Long> implements IPriceService {
    @Autowired
    private IPriceRepo repo;

    @Override
    public JpaRepository<Price, Long> getDao() {
        // TODO Auto-generated method stub
        return repo;
    }
}
