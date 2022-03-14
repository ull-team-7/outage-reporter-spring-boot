/*

package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.exception.OutageNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import com.team7.outagereporter.outagereporterspringboot.repository.OutageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/outages")
public class OutageController {

    private final OutageRepository repository;

    OutageController(OutageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    List<Outage> all() {
        return repository.findAll();
    }

    @PostMapping("/add")
    Outage newOutage(@RequestBody Outage outage) {
        return repository.save(outage);
    }

    @GetMapping("/find/{id}")
    Outage one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new OutageNotFoundException(id));
    }

    @PutMapping("/update/{id}")
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

    @DeleteMapping("/delete/{id}")
    void deleteOutage(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
*/
