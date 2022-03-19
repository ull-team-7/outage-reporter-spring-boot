package com.team7.outagereporter.outagereporterspringboot;

import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import com.team7.outagereporter.outagereporterspringboot.entity.Utility;
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
    CommandLineRunner initDatabaseOutage(OutageRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Outage("John", "Smith", "Apple Dr.", "12345", "john.smith@example.com", "Power went out an hour ago.")));
            log.info("Preloading " + repository.save(new Outage("Jane", "Doe", "Orange St.", "98765", "jane.doe@example.com", "Power has been intermittent since this morning.")));
        };
    }

    @Bean
    CommandLineRunner initDatabaseUtility(UtilityRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Utility("Slemco", "slemcosupport@slemco.com", "https://www.slemco.com")));
            log.info("Preloading " + repository.save(new Utility("Entergy", "entergysupport@entergy.com", "https://www.entergy.com")));
        };
    }

}
