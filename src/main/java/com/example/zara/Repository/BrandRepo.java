package com.example.zara.Repository;
import com.example.zara.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//********************************************************//
//*********************Brand Repository*******************//
//********************************************************//
@Repository
public interface BrandRepo extends JpaRepository<Brand, Long>{
    
}
