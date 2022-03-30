package com.team7.outagereporter.outagereporterspringboot.service;

import com.team7.outagereporter.outagereporterspringboot.entity.Utility;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UtilityServiceImpl implements UtilityService {

    @Autowired
    private UtilityRepository utilityRepository;

    @Override
    public Optional<Utility> findById(Long id) {
        return utilityRepository.findById(id);
    }

}
