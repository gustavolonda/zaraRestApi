package com.example.zara.Sevice.Brand;
import com.example.zara.Model.Brand;
import com.example.zara.Repository.IBrandRepo;
import com.example.zara.Sevice.Generic.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

//********************************************************//
//****************** Brand Service ***********************//
//********************************************************//

@Service
public class BrandServiceImpl extends GenericServiceImpl<Brand, Long> implements IBrandService {
    @Autowired
    private IBrandRepo repo;

    @Override
    public JpaRepository<Brand, Long> getDao() {
        // TODO Auto-generated method stub
        return repo;
    }
    
}
