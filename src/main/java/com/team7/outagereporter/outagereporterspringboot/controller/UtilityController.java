package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.entity.Utility;
import com.team7.outagereporter.outagereporterspringboot.exception.UtilityNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilityController {

    private final UtilityRepository repository;

    UtilityController(UtilityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/utility")
    List<Utility> all() {
        return repository.findAll();
    }

    @PostMapping("/utility")
    Utility newUtility(@RequestBody Utility utility) {
        return repository.save(utility);
    }

    @GetMapping("/utility/{id}")
    Utility one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UtilityNotFoundException(id));
    }

    @PutMapping("/utility/{id}")
    Utility replaceUtility(@RequestBody Utility newUtility, @PathVariable Long id) {
        return repository.findById(id)
                .map(utility -> {
                    if(newUtility.getName() == null){newUtility.setName(utility.getName());}
                    utility.setName(newUtility.getName());
                    if(newUtility.getEmail() == null){newUtility.setEmail(utility.getEmail());}
                    utility.setEmail(newUtility.getEmail());
                    if(newUtility.getWebsite() == null){newUtility.setWebsite(utility.getWebsite());}
                    utility.setWebsite(newUtility.getWebsite());
                    return repository.save(utility);
                }).orElseGet(() -> {
                    newUtility.setUtilityId(id);
                    return repository.save(newUtility);
                });
    }

    @DeleteMapping("/utility/{id}")
    void deleteUtility(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
