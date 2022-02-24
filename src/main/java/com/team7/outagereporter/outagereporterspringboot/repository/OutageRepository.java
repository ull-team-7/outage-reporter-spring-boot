package com.team7.outagereporter.outagereporterspringboot.repository;

import com.team7.outagereporter.outagereporterspringboot.entity.Outage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutageRepository extends JpaRepository<Outage, Long> {
}
