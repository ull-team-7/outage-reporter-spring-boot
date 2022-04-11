package com.team7.outagereporter.outagereporterspringboot.exception;

public class UtilityAreaNotFoundException extends RuntimeException{

    public UtilityAreaNotFoundException(Long id) {
        super("Could not find Utility Area " + id);
    }
}
