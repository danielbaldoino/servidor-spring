package com.example.servidor_spring.controller;

import com.example.servidor_spring.dto.TripDTO;
import com.example.servidor_spring.entity.Driver;
import com.example.servidor_spring.entity.Trip;
import com.example.servidor_spring.entity.Vehicle;
import com.example.servidor_spring.repository.DriverRepository;
import com.example.servidor_spring.repository.TripRepository;
import com.example.servidor_spring.repository.VehicleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripRepository tripRepository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    @PostMapping
    public ResponseEntity<Trip> create(@Valid @RequestBody TripDTO dto) {
        Driver driver = driverRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Trip trip = dto.toModel(driver, vehicle);
        Trip saved = tripRepository.save(trip);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> findById(@PathVariable Long id) {
        return tripRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!tripRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tripRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
