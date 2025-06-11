package com.example.servidor_spring.dto;

import com.example.servidor_spring.entity.Driver;
import com.example.servidor_spring.entity.Trip;
import com.example.servidor_spring.entity.Vehicle;
import com.example.servidor_spring.enums.TripStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TripDTO {
    private Long id;

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    @NotNull
    private LocalDate departureDate;

    private LocalDate arrivalDate;

    @NotNull
    private TripStatus status;

    @NotNull
    private Long driverId;

    @NotNull
    private Long vehicleId;

    public Trip toModel(Driver driver, Vehicle vehicle) {
        Trip trip = new Trip();
        trip.setId(this.id);
        trip.setOrigin(this.origin);
        trip.setDestination(this.destination);
        trip.setDepartureDate(this.departureDate);
        trip.setArrivalDate(this.arrivalDate);
        trip.setStatus(this.status);
        trip.setDriver(driver);
        trip.setVehicle(vehicle);
        return trip;
    }
}
