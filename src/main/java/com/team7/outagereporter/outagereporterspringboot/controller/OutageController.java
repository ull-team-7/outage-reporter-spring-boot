package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.exception.OutageNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import com.team7.outagereporter.outagereporterspringboot.repository.OutageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "${origins}")
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

    @PutMapping("/outages/{id}")
    Outage replaceOutage(@RequestBody Outage newOutage, @PathVariable Long id) {
        return repository.findById(id)
                .map(outage -> {
                    if(newOutage.getUtility() != null) {
                        outage.setUtility(newOutage.getUtility());
                    }
                    if (newOutage.getFirstName() != null) {
                        outage.setFirstName(newOutage.getFirstName());
                    }
                    if (newOutage.getLastName() != null) {
                        outage.setLastName(newOutage.getLastName());
                    }
                    if (newOutage.getStreetAddress() != null) {
                        outage.setStreetAddress(newOutage.getStreetAddress());
                    }
                    if (newOutage.getZipCode() != null) {
                        newOutage.setZipCode(outage.getZipCode());
                        outage.setZipCode(newOutage.getZipCode());
                    }
                    if (newOutage.getEmail() != null) {
                        outage.setEmail(newOutage.getEmail());
                    }
                    if (newOutage.getComment() != null) {
                        outage.setComment(newOutage.getComment());
                    }
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
