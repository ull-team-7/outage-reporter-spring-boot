package com.team7.outagereporter.outagereporterspringboot.service;

import com.team7.outagereporter.outagereporterspringboot.entity.Utility;

import java.util.Optional;

public interface UtilityService {

    Optional<Utility> findById(Long id);

}
