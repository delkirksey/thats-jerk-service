package repositories;

import models.TruckLocations;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TruckLocationsRepository extends JpaRepository<TruckLocations, Long> {
}
