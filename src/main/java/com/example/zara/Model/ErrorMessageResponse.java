package com.example.zara.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageResponse {
    private String errorMessage;

    public ErrorMessageResponse() {
        this.errorMessage = "";
    }
    
    
}
