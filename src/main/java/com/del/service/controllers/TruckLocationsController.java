package com.del.service.controllers;

import com.del.service.models.TruckLocation;
import com.del.service.repositories.TruckLocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TruckLocationsController {

    private final TruckLocationsRepository truckLocationsRepository;

    @Autowired
    public TruckLocationsController(TruckLocationsRepository truckLocationsRepository) {
        this.truckLocationsRepository = truckLocationsRepository;
    }

    @GetMapping("trucklocations")
    public List<TruckLocation> getTruckLocations() {
        return truckLocationsRepository.findAll();
    }

    @PostMapping("trucklocations")
    public @ResponseBody ResponseEntity<String> addTruckLocation(@RequestBody TruckLocation truckLocation) {
        truckLocationsRepository.save(truckLocation);
        return new ResponseEntity<String>("Truck Location created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("trucklocations")
    public @ResponseBody ResponseEntity<String> deleteTruckLocation(@RequestBody Long id) {
        truckLocationsRepository.delete(id);
        return new ResponseEntity<String>(String.format("Truck Location with ID: %s deleted", id), HttpStatus.ACCEPTED);
    }
}
