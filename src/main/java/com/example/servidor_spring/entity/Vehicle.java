package com.example.servidor_spring.entity;
import com.example.servidor_spring.enums.VehicleType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String licensePlate;

    private String model;
    private String brand;
    private Integer year;
    private Double capacityKg;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
}
