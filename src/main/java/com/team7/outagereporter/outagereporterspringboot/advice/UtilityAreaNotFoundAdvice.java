package com.team7.outagereporter.outagereporterspringboot.advice;

import com.team7.outagereporter.outagereporterspringboot.exception.UtilityAreaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UtilityAreaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UtilityAreaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String utilityAreaNotFoundHandler(UtilityAreaNotFoundException ex) {
        return ex.getMessage();
    }
}
