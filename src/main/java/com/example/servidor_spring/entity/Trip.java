package com.example.servidor_spring.entity;

import com.example.servidor_spring.enums.TripStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "trips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
