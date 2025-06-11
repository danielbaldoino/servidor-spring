package com.example.servidor_spring.controller;

import com.example.servidor_spring.dto.DriverDTO;
import com.example.servidor_spring.entity.Driver;
import com.example.servidor_spring.repository.DriverRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverRepository driverRepository;

    @PostMapping
    public ResponseEntity<Driver> create(@Valid @RequestBody DriverDTO dto) {
        Driver driver = dto.toModel();
        Driver saved = driverRepository.save(driver);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> findById(@PathVariable Long id) {
        return driverRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!driverRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        driverRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
