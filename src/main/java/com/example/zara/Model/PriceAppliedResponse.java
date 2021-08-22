package com.example.zara.Model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceAppliedResponse {
    private long productId;
    private long brandId;
    private long priceList;
    public String dateApplyPrice;
    // Price
    private double price;
    public PriceAppliedResponse() {
        this.productId      = 0;
        this.brandId        = 0;
        this.priceList      = 0;
        this.price          = 0.0;
        this.dateApplyPrice = "";
    }
    
}
