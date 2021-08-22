package com.example.zara.Sevice.Price;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.zara.Model.Price;
import com.example.zara.Model.PriceAppliedResponse;
import com.example.zara.Repository.IPriceRepo;
import com.example.zara.Sevice.Generic.GenericServiceImpl;
import com.example.zara.Util.UtilString;

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

    @Override
    public PriceAppliedResponse appliedPrice(String dateApplyPriceString, long productId, long brandId) {
        // TODO Auto-generated method stub
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(UtilString.FORMAT_DATE); 
        LocalDateTime dateTime = LocalDateTime.parse(dateApplyPriceString, formatter);
        PriceAppliedResponse priceAppliedResponse = new PriceAppliedResponse();
        Price price = repo.findFirstByStartDateLessThanEqualAndEndDateGreaterThanAndProductProductIdEqualsAndBrandBrandIdEqualsOrderByPriorityDescStartDate(dateTime,dateTime, productId, brandId);
        if(price == null)
            return priceAppliedResponse;

        priceAppliedResponse.setBrandId(price.getBrand().getBrandId());
        priceAppliedResponse.setProductId(price.getProduct().getProductId());
        priceAppliedResponse.setPriceList(price.getPriceList());
        priceAppliedResponse.setPrice(price.getPrice());
        priceAppliedResponse.setDateApplyPrice(dateApplyPriceString);
        return priceAppliedResponse;
    }
}
