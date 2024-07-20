package com.example.library.library.managment.error_response;

import lombok.Data;

@Data
public class Error_Response {
    private  String message;
    private Integer status_code;
}
