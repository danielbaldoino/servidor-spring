package com.example.servidor_spring.controller;


import com.example.servidor_spring.dto.VehicleDTO;
import com.example.servidor_spring.entity.Vehicle;
import com.example.servidor_spring.repository.VehicleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @PostMapping
    public ResponseEntity<Vehicle> create(@Valid @RequestBody VehicleDTO dto) {
        Vehicle vehicle = dto.toModel();
        Vehicle saved = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
        return vehicleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!vehicleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

