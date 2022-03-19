package com.team7.outagereporter.outagereporterspringboot.advice;

import com.team7.outagereporter.outagereporterspringboot.exception.UtilityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UtilityNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UtilityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String utilityNotFoundHandler(UtilityNotFoundException ex) {
        return ex.getMessage();
    }
}
