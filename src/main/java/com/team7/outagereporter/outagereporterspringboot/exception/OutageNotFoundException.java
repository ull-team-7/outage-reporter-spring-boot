package com.team7.outagereporter.outagereporterspringboot.exception;

public class OutageNotFoundException extends RuntimeException {

    public OutageNotFoundException(Long id) {
        super("Could not find outage " + id);
    }
}
