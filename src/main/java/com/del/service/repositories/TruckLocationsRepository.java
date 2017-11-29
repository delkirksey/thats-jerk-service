package com.del.service.repositories;

import com.del.service.models.TruckLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TruckLocationsRepository extends JpaRepository<TruckLocation, Long> {
}
