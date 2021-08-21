package com.example.zara.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PriceRequest {
    private List<Price> priceList;

    public PriceRequest() {
        this.priceList = new ArrayList<>();
    }
    
    
}
