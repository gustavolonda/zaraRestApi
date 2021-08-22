package com.example.zara;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.zara.Model.PriceAppliedResponse;
import com.example.zara.Sevice.Price.IPriceService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {
    private final static String URI = "/api/price";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IPriceService priceService;

    
    // 1st TEST: To obtain the application date, enter the following parameters: dateAppliedPrice = '2020-06-14-10.00.00'
    //                                                                 productId        =  35455
    //                                                                 brandID          = 1
    @Test                                                                
    void testOne()  {

        String priceApplyURL = URI+"/dateApplyPrice/2020-06-14-10.00.00/35455/1";
        // given
        PriceAppliedResponse priceAppliedResponse= new PriceAppliedResponse();
        priceAppliedResponse.setBrandId(1);
        priceAppliedResponse.setProductId(35455);
        priceAppliedResponse.setPriceList(1);
        priceAppliedResponse.setDateApplyPrice("2020-06-14-10.00.00");
        priceAppliedResponse.setPrice(35.5);

        given(priceService.appliedPrice("2020-06-14-10.00.00",35455,1)).willReturn(priceAppliedResponse);
        // when + then
        try {
                mvc.perform(get(priceApplyURL)
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().json("{'productId': 35455,"+
                                            "'brandId': 1,"+
                                            "'priceList': 1,"+
                                            "'dateApplyPrice': '2020-06-14-10.00.00',"+
                                            "'price': 35.5}"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 2nd TEST: To obtain the application date, enter the following parameters: dateAppliedPrice = '2020-06-14-16.00.00'
    //                                                                 productId        =  35455
    //                                                                 brandID          = 1
    @Test
    void testTwo()  {
        String priceApplyURL = URI+"/dateApplyPrice/2020-06-14-16.00.00/35455/1";
        // given
        PriceAppliedResponse priceAppliedResponse= new PriceAppliedResponse();
        priceAppliedResponse.setBrandId(1);
        priceAppliedResponse.setProductId(35455);
        priceAppliedResponse.setPriceList(1);
        priceAppliedResponse.setDateApplyPrice("2020-06-14-16.00.00");
        priceAppliedResponse.setPrice(25.45);

        given(priceService.appliedPrice("2020-06-14-16.00.00",35455,1)).willReturn(priceAppliedResponse);

        // when + then
        try {
                mvc.perform(get(priceApplyURL))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{'productId': 35455,"+
                                            "'brandId': 1,"+
                                            "'priceList': 1,"+
                                            "'dateApplyPrice': '2020-06-14-16.00.00',"+
                                            "'price': 25.45}"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // 3st TEST: To obtain the application date, enter the following parameters: dateAppliedPrice = '2020-06-14-21.00.00'
    //                                                                 productId        =  35455
    //                                                                 brandID          = 1
    @Test
    void testThree()  {
        String priceApplyURL = URI+"/dateApplyPrice/2020-06-14-21.00.00/35455/1";
        // given
        PriceAppliedResponse priceAppliedResponse= new PriceAppliedResponse();
        priceAppliedResponse.setBrandId(1);
        priceAppliedResponse.setProductId(35455);
        priceAppliedResponse.setPriceList(1);
        priceAppliedResponse.setDateApplyPrice("2020-06-14-21.00.00");
        priceAppliedResponse.setPrice(35.5);

        given(priceService.appliedPrice("2020-06-14-21.00.00",35455,1)).willReturn(priceAppliedResponse);

        // when + then
        try {
                mvc.perform(get(priceApplyURL))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{'productId': 35455,"+
                                            "'brandId': 1,"+
                                            "'priceList': 1,"+
                                            "'dateApplyPrice': '2020-06-14-21.00.00',"+
                                            "'price': 35.5}"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 4th TEST: To obtain the application date, enter the following parameters: dateAppliedPrice = '2020-06-15-10.00.00'
    //                                                                 productId        =  35455
    //                                                                 brandID          = 1
    @Test
    void testFour()  {
        String priceApplyURL = URI+"/dateApplyPrice/2020-06-15-10.00.00/35455/1";
        // given
        PriceAppliedResponse priceAppliedResponse= new PriceAppliedResponse();
        priceAppliedResponse.setBrandId(1);
        priceAppliedResponse.setProductId(35455);
        priceAppliedResponse.setPriceList(1);
        priceAppliedResponse.setDateApplyPrice("2020-06-15-10.00.00");
        priceAppliedResponse.setPrice(30.5);

        given(priceService.appliedPrice("2020-06-15-10.00.00",35455,1)).willReturn(priceAppliedResponse);

        // when + then
        try {
                mvc.perform(get(priceApplyURL))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{'productId': 35455,"+
                                            "'brandId': 1,"+
                                            "'priceList': 1,"+
                                            "'dateApplyPrice': '2020-06-15-10.00.00',"+
                                            "'price': 30.5}"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 5th TEST: To obtain the application date, enter the following parameters: dateAppliedPrice = '2020-06-16-21.00.00'
    //                                                                 productId        =  35455
    //                                                                 brandID          = 1
    @Test
    void testFive()  {
        String priceApplyURL = URI+"/dateApplyPrice/2020-06-16-21.00.00/35455/1";
        // given
        PriceAppliedResponse priceAppliedResponse= new PriceAppliedResponse();
        priceAppliedResponse.setBrandId(1);
        priceAppliedResponse.setProductId(35455);
        priceAppliedResponse.setPriceList(1);
        priceAppliedResponse.setDateApplyPrice("2020-06-16-21.00.00");
        priceAppliedResponse.setPrice(38.95);

        given(priceService.appliedPrice("2020-06-16-21.00.00",35455,1)).willReturn(priceAppliedResponse);

        // when + then
        try {
                mvc.perform(get(priceApplyURL))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{'productId': 35455,"+
                                            "'brandId': 1,"+
                                            "'priceList': 1,"+
                                            "'dateApplyPrice': '2020-06-16-21.00.00',"+
                                            "'price': 38.95}"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
