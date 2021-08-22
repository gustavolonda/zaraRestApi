package com.example.zara.Sevice.Price;

import com.example.zara.Model.Price;
import com.example.zara.Model.PriceAppliedResponse;
import com.example.zara.Sevice.Generic.GenericServiceAPI;

//********************************************************//
//************ Interface Price Service *******************//
//********************************************************//
public interface IPriceService extends GenericServiceAPI<Price, Long> {
    PriceAppliedResponse appliedPrice(String dateApplyPriceString, long productId, long brandId);

}
