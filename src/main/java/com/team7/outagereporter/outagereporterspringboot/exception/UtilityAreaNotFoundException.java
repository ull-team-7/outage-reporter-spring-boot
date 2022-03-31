package com.team7.outagereporter.outagereporterspringboot.exception;

import com.team7.outagereporter.outagereporterspringboot.entity.UtilityArea;

public class UtilityAreaNotFoundException extends RuntimeException {

    public UtilityAreaNotFoundException(UtilityArea.Pk id) {
        super("Could not find utility area " + id);
    }
}
