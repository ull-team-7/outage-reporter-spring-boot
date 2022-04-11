package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.entity.Utility;
import com.team7.outagereporter.outagereporterspringboot.entity.UtilityArea;
import com.team7.outagereporter.outagereporterspringboot.exception.UtilityAreaNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.exception.UtilityNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilityAreaController {

    private final UtilityRepository repository;

    UtilityAreaController(UtilityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/utility/{id}/area")
    Set<UtilityArea> all(@PathVariable Long id) {
        Utility utility = repository.findById(id)
                .orElseThrow(() -> new UtilityNotFoundException(id));
        return utility.getUtilityAreas();
    }

    @PostMapping("/utility/{id}/area")
    Utility newUtilityArea(@RequestBody UtilityArea utilityArea, @PathVariable Long id) {
        Utility utility = repository.findById(id)
                .orElseThrow(() -> new UtilityNotFoundException(id));
        utility.getUtilityAreas().add(utilityArea);
        return repository.save(utility);
    }

    @GetMapping("/utility/{id}/area/{zipCode}")
    UtilityArea one(@PathVariable Long id, @PathVariable String zipCode) {
        Utility utility = repository.findById(id)
                .orElseThrow(() -> new UtilityNotFoundException(id));
        Set<UtilityArea> utilityAreas = utility.getUtilityAreas();

        return utilityAreas.stream().filter(e -> e.getZipCode().equals(zipCode)).findFirst()
                .orElseThrow(() -> new UtilityAreaNotFoundException(zipCode));
    }

    @PutMapping("/utility/{id}/area/{zipCode}")
    Utility replaceUtilityArea(@RequestBody UtilityArea newUtilityArea, @PathVariable Long id, @PathVariable String zipCode) {
        Utility utility = repository.findById(id)
                .orElseThrow(() -> new UtilityNotFoundException(id));
        Set<UtilityArea> utilityAreas = utility.getUtilityAreas();

        UtilityArea utilityArea = utilityAreas.stream().filter(e -> e.getZipCode().equals(zipCode)).findFirst()
                .orElseThrow(() -> new UtilityAreaNotFoundException(zipCode));

        utilityArea.setOutageStatus(newUtilityArea.getOutageStatus());
        utilityArea.setTimeToFix(newUtilityArea.getTimeToFix());
        utilityArea.setComment(newUtilityArea.getComment());

        return repository.save(utility);
    }

    @DeleteMapping("/utility/{id}/area/{zipCode}")
    void deleteUtilityArea(@PathVariable Long id, @PathVariable String zipCode) {
        Utility utility = repository.findById(id)
                .orElseThrow(() -> new UtilityNotFoundException(id));

        Set<UtilityArea> utilityAreas = utility.getUtilityAreas();
        UtilityArea utilityArea = utilityAreas.stream().filter(e -> e.getZipCode().equals(zipCode)).findFirst()
                .orElseThrow(() -> new UtilityAreaNotFoundException(zipCode));

        utility.getUtilityAreas().remove(utilityArea);
        repository.save(utility);
    }

}
