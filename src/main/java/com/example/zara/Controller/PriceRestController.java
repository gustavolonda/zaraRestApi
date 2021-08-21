package com.example.zara.Controller;
import java.util.List;

import com.example.zara.Model.ErrorMessageResponse;
import com.example.zara.Model.MessageResponse;
import com.example.zara.Model.Price;
import com.example.zara.Model.PriceRequest;
import com.example.zara.Model.Response;
import com.example.zara.Sevice.Price.IPriceService;
import com.example.zara.Util.UtilString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gustavo Londa
 */
@RestController
@RequestMapping("/api/price")
public class PriceRestController {
    @Autowired
    private IPriceService priceService;
    @GetMapping
    public ResponseEntity<List<Price>> getAll(){
        List<Price> priceList = priceService.getAll();
        return new ResponseEntity<>(priceList,HttpStatus.OK);
    }
    @GetMapping(value = "/dateApplyPrice/{dateApplyPrice}")
    public ResponseEntity<Price> getAppliedPriceByDate(@PathVariable("dateApplyPrice") String dateApplyPrice ){
        Price price = priceService.appliedPrice(dateApplyPrice);
        return new ResponseEntity<>(price,HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Response>  save(@RequestBody Price price){
        Price priceResponse = priceService.save(price);
        Response response = new Response();
        if(priceResponse == null){
            response.setStatus(UtilString.RESPONSE_STATUS_ERROR);
            ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
            errorMessageResponse.setErrorMessage("An error occurred, please try again");
            response.setResul(errorMessageResponse);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(UtilString.RESPONSE_STATUS_OK);
        response.setResul(priceResponse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<Response> saveAll(@RequestBody PriceRequest priceRequest){
        
        List<Price> priceListResponse = priceService.saveAll(priceRequest.getPriceList());
        Response response = new Response();
        if(priceListResponse == null || priceListResponse.size() == 0){
            response.setStatus(UtilString.RESPONSE_STATUS_ERROR);
            ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
            errorMessageResponse.setErrorMessage("An error occurred, please try again");
            response.setResul(errorMessageResponse);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(UtilString.RESPONSE_STATUS_OK);
        response.setResul(priceListResponse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Response>  update(@RequestBody Price price){
        Price priceResponse = priceService.save(price);
        Response response = new Response();
        if(priceResponse == null){
            response.setStatus(UtilString.RESPONSE_STATUS_ERROR);
            ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
            errorMessageResponse.setErrorMessage("An error occurred, please try again");
            response.setResul(errorMessageResponse);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(UtilString.RESPONSE_STATUS_OK);
        response.setResul(priceResponse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
	
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response>  eliminar(@PathVariable("id") long id) {
        priceService.delete(id);
        Price priceResponse = priceService.get(id);
        Response response = new Response();
        if(priceResponse != null){
            response.setStatus(UtilString.RESPONSE_STATUS_ERROR);
            ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
            errorMessageResponse.setErrorMessage("An error occurred, please try again");
            response.setResul(errorMessageResponse);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Successfully completed!");
        response.setStatus(UtilString.RESPONSE_STATUS_OK);
        response.setResul(messageResponse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    } 
    
}
