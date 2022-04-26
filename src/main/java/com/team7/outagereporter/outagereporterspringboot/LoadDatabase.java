package com.team7.outagereporter.outagereporterspringboot;

import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import com.team7.outagereporter.outagereporterspringboot.entity.Utility;
import com.team7.outagereporter.outagereporterspringboot.entity.UtilityArea;
import com.team7.outagereporter.outagereporterspringboot.repository.OutageRepository;
import com.team7.outagereporter.outagereporterspringboot.repository.UtilityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(OutageRepository outageRepository, UtilityRepository utilityRepository) {
        return args -> {
            Outage outage1 = new Outage("John", "Smith", "Apple Dr.", "12345", "john.smith@example.com", "Power went out an hour ago.");
            Outage outage2 = new Outage("Jane", "Doe", "Orange St.", "98765", "jane.doe@example.com", "Power has been intermittent since this morning.");

            log.info("Preloading " + outageRepository.save(outage1));
            log.info("Preloading " + outageRepository.save(outage2));

            Utility utility1 = new Utility("Slemco", "slemcosupport@slemco.com", "https://www.slemco.com");
            Utility utility2 = new Utility("Entergy", "entergysupport@entergy.com", "https://www.entergy.com");
            log.info("Preloading " + utilityRepository.save(utility1));
            log.info("Preloading " + utilityRepository.save(utility2));

            Utility x = utilityRepository.findById(1L).get();
            x.getUtilityAreas().add(new UtilityArea("70555", true, "1 hour", "Sorry for any inconvenience."));
            x.getUtilityAreas().add(new UtilityArea("70506", true, "30 minutes", "It'll be fixed shortly."));
            x.getUtilityAreas().add(new UtilityArea("70123", false, null, null));
            log.info("Updating " + utilityRepository.save(x));
        };
    }

}
