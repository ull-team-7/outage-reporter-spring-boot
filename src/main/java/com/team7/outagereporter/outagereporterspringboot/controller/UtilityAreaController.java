package com.team7.outagereporter.outagereporterspringboot.controller;


import com.team7.outagereporter.outagereporterspringboot.entity.UtilityArea;
import com.team7.outagereporter.outagereporterspringboot.exception.UtilityAreaNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:4200")
public class UtilityAreaController {
    @Autowired
    private final UtilityAreaRepository utilityAreaRepository;

    public UtilityAreaController (UtilityAreaRepository repository){this.utilityAreaRepository = repository;}

    @GetMapping("/utilityArea")
    List<UtilityArea> all(){return utilityAreaRepository.findAll();}

    @PostMapping("/utilityArea")
    UtilityArea newUtilityArea(@RequestBody UtilityArea utilityArea){return utilityAreaRepository.save(utilityArea);}

    @GetMapping("/utilityArea/{id}")
    UtilityArea one(@PathVariable Long id) {
        return utilityAreaRepository.findById(id)
                .orElseThrow(() -> new UtilityAreaNotFoundException(id));
    }

    @PutMapping("/utilityArea/{id}")
    UtilityArea replaceUtilityArea(@RequestBody UtilityArea newUtilityArea, @PathVariable Long id) {
        return utilityAreaRepository.findById(id)
                .map(utilityArea -> {
                    utilityArea.setComment(newUtilityArea.getComment());
                    utilityArea.setTimeToFix(newUtilityArea.getTimeToFix());
                    utilityArea.setZipCode(newUtilityArea.getZipCode());
                    return utilityAreaRepository.save(utilityArea);
                }).orElseGet(() -> {
                    newUtilityArea.setUtilityAreaId(id);
                    return utilityAreaRepository.save(newUtilityArea);
                });
    }


    @DeleteMapping("/utilityArea/{id}")
    void deleteOutage(@PathVariable Long id) {
        utilityAreaRepository.deleteById(id);
    }

}