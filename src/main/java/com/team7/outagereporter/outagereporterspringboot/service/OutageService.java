
package com.team7.outagereporter.outagereporterspringboot.service;

import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import com.team7.outagereporter.outagereporterspringboot.exception.OutageNotFoundException;
import com.team7.outagereporter.outagereporterspringboot.repository.OutageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutageService {
    private final OutageRepository outageRepository;

    @Autowired
    public OutageService(OutageRepository outageRepository)
    {
        this.outageRepository = outageRepository;
    }

    public Outage addOutages(Outage outages){
        if(outages.getFirstName() == null){ outages.setFirstName(outages.getNoAnswer());}
        if(outages.getLastName() == null){ outages.setLastName(outages.getNoAnswer());}
        if(outages.getStreetAddress() == null){ outages.setStreetAddress(outages.getNoAnswer());}
        if(outages.getEmail() == null){ outages.setEmail(outages.getNoAnswer());}
        if(outages.getComment() == null){ outages.setComment(outages.getNoAnswer());}
        return outageRepository.save(outages);
    }

    public List<Outage> findAllOutages(){
        return outageRepository.findAll();
    }
    public Outage updateOutage(Outage newOutage,Long id){


        return outageRepository.findById(id)
                .map(outage -> {
                    if(newOutage.getFirstName() == null){ newOutage.setFirstName(outage.getFirstName());}
                    outage.setFirstName(newOutage.getFirstName());
                    if(newOutage.getLastName() == null){ newOutage.setLastName(outage.getLastName());}
                    outage.setLastName(newOutage.getLastName());
                    if(newOutage.getStreetAddress() == null){ newOutage.setStreetAddress(outage.getStreetAddress());}
                    outage.setStreetAddress(newOutage.getStreetAddress());
                    if(newOutage.getZipCode() == null){ newOutage.setZipCode(outage.getZipCode());}
                    outage.setZipCode(newOutage.getZipCode());
                    if(newOutage.getEmail() == null){ newOutage.setEmail(outage.getEmail());}
                    outage.setEmail(newOutage.getEmail());
                    if(newOutage.getComment() == null){ newOutage.setComment(outage.getComment());}
                    outage.setComment(newOutage.getComment());
                    return outageRepository.save(outage);
                }).orElseGet(() -> {
                    newOutage.setId(id);
                    return outageRepository.save(newOutage);
                });
    }
    public Outage findOutageById(Long id){
        return outageRepository.findById(id).orElseThrow(() -> new OutageNotFoundException(id));
    }
    public void deleteOutage(Long id){
        outageRepository.deleteById(id);
    }
}