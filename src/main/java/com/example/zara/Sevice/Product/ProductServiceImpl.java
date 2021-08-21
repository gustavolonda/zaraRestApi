package com.example.zara.Sevice.Product;
import com.example.zara.Model.Product;
import com.example.zara.Repository.IProductRepo;
import com.example.zara.Sevice.Generic.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

//********************************************************//
//****************** Product Service *********************//
//********************************************************//
@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements IProductService {
    @Autowired
    private IProductRepo repo;

    @Override
    public JpaRepository<Product, Long> getDao() {
        // TODO Auto-generated method stub
        return repo;
    }
}
