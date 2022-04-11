package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.entity.Utility;
import com.team7.outagereporter.outagereporterspringboot.entity.UtilityArea;
import com.team7.outagereporter.outagereporterspringboot.exception.UtilityNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityAreaRepository;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilityController {

    @Autowired
    private final UtilityRepository utilityRepository;
    
    @Autowired
    private final UtilityAreaRepository utilityAreaRepository;

    UtilityController(UtilityRepository repository) {
        this.utilityRepository = repository;
        utilityAreaRepository = null;
    }

    @GetMapping("/utility")
    List<Utility> all() {
        return utilityRepository.findAll();
    }

    @PostMapping("/utility")
    Utility newUtility(@RequestBody Utility utility) {
        return utilityRepository.save(utility);
    }

    @GetMapping("/utility/{id}")
    Utility one(@PathVariable Long id) {
        return utilityRepository.findById(id)
                .orElseThrow(() -> new UtilityNotFoundException(id));
    }

    @PutMapping("/utility/{id}")
    Utility replaceUtility(@RequestBody Utility newUtility, @PathVariable Long id) {
        return utilityRepository.findById(id)
                .map(utility -> {
                    if(newUtility.getName() == null){newUtility.setName(utility.getName());}
                    utility.setName(newUtility.getName());
                    if(newUtility.getEmail() == null){newUtility.setEmail(utility.getEmail());}
                    utility.setEmail(newUtility.getEmail());
                    if(newUtility.getWebsite() == null){newUtility.setWebsite(utility.getWebsite());}
                    utility.setWebsite(newUtility.getWebsite());
                    return utilityRepository.save(utility);
                }).orElseGet(() -> {
                    newUtility.setUtilityId(id);
                    return utilityRepository.save(newUtility);
                });
    }

    @PutMapping("utility/{utilityId}/utilityArea/{utilityAreaId}")
    Utility assignUtilityAreaToUtility(
            @PathVariable Long utilityId,
            @PathVariable Long utilityAreaId
    ){
        Utility utility = utilityRepository.findById(utilityId).get();
        UtilityArea utilityArea = utilityAreaRepository.findById(utilityAreaId).get();
        utility.assignUtilityArea(utilityArea);
        return utilityRepository.save(utility);
    }

    @DeleteMapping("/utility/{id}")
    void deleteUtility(@PathVariable Long id) {
        utilityRepository.deleteById(id);
    }

}
