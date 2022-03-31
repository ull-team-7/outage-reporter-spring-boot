package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.entity.Utility;
import com.team7.outagereporter.outagereporterspringboot.entity.UtilityArea;
import com.team7.outagereporter.outagereporterspringboot.exception.UtilityAreaNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.exception.UtilityNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityAreaRepository;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilityAreaController {

    private final UtilityAreaRepository repository;
    private final UtilityRepository utilityRepository;

    UtilityAreaController(UtilityAreaRepository repository, UtilityRepository utilityRepository) {
        this.repository = repository;
        this.utilityRepository = utilityRepository;
    }

    @GetMapping("/utility-area")
    List<UtilityArea> all() {
        return repository.findAll();
    }

    @PostMapping("/utility-area")
    UtilityArea newUtilityArea(@RequestBody UtilityArea utilityArea) {
        return repository.save(utilityArea);
    }

    @GetMapping("/utility-area/{id}")
    UtilityArea one(@PathVariable UtilityArea.Pk id) {
        return repository.findById(id)
                .orElseThrow(() -> new UtilityAreaNotFoundException(id));
    }

    @PutMapping("/utility-area/{id}")
    UtilityArea replaceUtility(@RequestBody UtilityArea newUtilityArea, @PathVariable UtilityArea.Pk id) {
        return repository.findById(id)
                .map(utilityArea -> {
                    utilityArea.setTimeToFix(newUtilityArea.getTimeToFix());
                    utilityArea.setComment(newUtilityArea.getComment());
                    return repository.save(utilityArea);
                }).orElseGet(() -> {
                    newUtilityArea.setUtilityAreaId(id);
                    return repository.save(newUtilityArea);
                });
    }

    @DeleteMapping("/utility-area/{id}")
    void deleteUtility(@PathVariable UtilityArea.Pk id) {
        repository.deleteById(id);
    }

}
