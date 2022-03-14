

package com.team7.outagereporter.outagereporterspringboot.controller;

import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import com.team7.outagereporter.outagereporterspringboot.repository.OutageRepository;
import com.team7.outagereporter.outagereporterspringboot.service.OutageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/outages")
public class OutageResource {
    private final OutageService outageService;

    public OutageResource(OutageService outageService){
        this.outageService = outageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Outage>> getAllOutages(){
        List<Outage> outages = outageService.findAllOutages();
        return new ResponseEntity<>(outages , HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Outage> getOutagesById(@PathVariable("id") Long id){
        Outage outages = outageService.findOutageById(id);
        return new ResponseEntity<>(outages , HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Outage> addOutage(@RequestBody Outage outages){
        Outage newOutages = outageService.addOutages(outages);
        return new ResponseEntity<>(newOutages , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Outage> updateOutage(@RequestBody Outage outages,@PathVariable("id") Long id){
        Outage updateOutages = outageService.updateOutage(outages,id);
        return new ResponseEntity<>(updateOutages , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOutage(@PathVariable("id") Long id){
        outageService.deleteOutage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
