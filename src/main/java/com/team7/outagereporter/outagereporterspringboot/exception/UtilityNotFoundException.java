package com.team7.outagereporter.outagereporterspringboot.exception;

public class UtilityNotFoundException extends RuntimeException {

    public UtilityNotFoundException(Long id) {
        super("Could not find Utility " + id);
    }
}
