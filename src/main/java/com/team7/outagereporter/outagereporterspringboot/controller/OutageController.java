package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.advice.OutageNotFoundAdvice;
import com.team7.outagereporter.outagereporterspringboot.exception.OutageNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import com.team7.outagereporter.outagereporterspringboot.repository.OutageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "moz-extension://906743b7-28d1-4dc0-a562-5246d630474a"})
public class OutageController {

    private final OutageRepository repository;

    OutageController(OutageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/outages")
    List<Outage> all() {
        return repository.findAll();
    }

    @PostMapping("/outages")
    Outage newOutage(@RequestBody Outage outage) {
        return repository.save(outage);
    }

    @GetMapping("/outages/{id}")
    Outage one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new OutageNotFoundException(id));
    }

    @PatchMapping("/outages/{id}")
    Outage updateOutage(@RequestBody Outage outage, @PathVariable Long id) {
        return repository.findById(id)
                .map(updatedOutage -> {
                    updatedOutage.setFirstName(outage.getFirstName());
                    updatedOutage.setLastName(outage.getLastName());
                    updatedOutage.setStreetAddress(outage.getStreetAddress());
                    updatedOutage.setZipCode(outage.getZipCode());
                    updatedOutage.setEmail(outage.getEmail());
                    updatedOutage.setComment(outage.getComment());
                    return repository.save(updatedOutage);
                }).orElseThrow(() -> new OutageNotFoundException(id));

    }

    @PutMapping("/outages/{id}")
    Outage replaceOutage(@RequestBody Outage newOutage, @PathVariable Long id) {
        return repository.findById(id)
                .map(outage -> {
                    outage.setFirstName(newOutage.getFirstName());
                    outage.setLastName(newOutage.getLastName());
                    outage.setStreetAddress(newOutage.getStreetAddress());
                    outage.setZipCode(newOutage.getZipCode());
                    outage.setEmail(newOutage.getEmail());
                    outage.setComment(newOutage.getComment());
                    return repository.save(outage);
                }).orElseGet(() -> {
                    newOutage.setId(id);
                    return repository.save(newOutage);
                });
    }

    @DeleteMapping("/outages/{id}")
    void deleteOutage(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
