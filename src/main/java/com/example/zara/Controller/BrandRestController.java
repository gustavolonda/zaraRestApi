package com.example.zara.Controller;
import java.util.List;

import com.example.zara.Model.Brand;
import com.example.zara.Model.ErrorMessageResponse;
import com.example.zara.Model.MessageResponse;
import com.example.zara.Model.Response;
import com.example.zara.Sevice.Brand.IBrandService;
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
@RequestMapping("/api/brand")
public class BrandRestController {
    @Autowired
    private IBrandService brandService;
    @GetMapping
    public ResponseEntity<List<Brand>> getAll(){
        List<Brand> brandList = brandService.getAll();
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Brand brand){
        
        Brand brandResponse =  brandService.save(brand);
        Response response = new Response();
        if(brandResponse == null){
            response.setStatus(UtilString.RESPONSE_STATUS_ERROR);
            ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
            errorMessageResponse.setErrorMessage("An error occurred, please try again");
            response.setResul(errorMessageResponse);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(UtilString.RESPONSE_STATUS_OK);
        response.setResul(brandResponse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Response> update(@RequestBody Brand brand){
        Brand brandResponse =  brandService.save(brand);
        Response response = new Response();
        if(brandResponse == null){
            response.setStatus(UtilString.RESPONSE_STATUS_ERROR);
            ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
            errorMessageResponse.setErrorMessage("An error occurred, please try again");
            response.setResul(errorMessageResponse);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(UtilString.RESPONSE_STATUS_OK);
        response.setResul(brandResponse);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
	
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> eliminar(@PathVariable("id") long id) {
        brandService.delete(id);
        Brand brandResponse = brandService.get(id);
        Response response = new Response();
        if(brandResponse != null){
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
