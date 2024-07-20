package com.example.library.library.managment.handle_exception;

import com.example.library.library.managment.error_response.Error_Response;
import com.example.library.library.managment.exception.NOT_FOUND_ID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(NOT_FOUND_ID.class)
    public ResponseEntity<Error_Response> handlerNotFound(NOT_FOUND_ID ex){
        Error_Response err=new Error_Response();
        err.setStatus_code(500);
        err.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
