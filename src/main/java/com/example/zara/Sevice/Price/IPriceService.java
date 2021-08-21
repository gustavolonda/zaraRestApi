package com.example.zara.Sevice.Price;


import com.example.zara.Model.Price;
import com.example.zara.Sevice.Generic.GenericServiceAPI;

//********************************************************//
//************ Interface Price Service *******************//
//********************************************************//
public interface IPriceService extends GenericServiceAPI<Price, Long> {
    Price appliedPrice(String dateApplyPriceString);
    
}
