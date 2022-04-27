package com.team7.outagereporter.outagereporterspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OutageReporterSpringBootApplication {

	public static void main(String[] args) {
		for(String arg:args) {
			System.out.println(arg);
		}
		SpringApplication.run(OutageReporterSpringBootApplication.class, args);
	}

}
