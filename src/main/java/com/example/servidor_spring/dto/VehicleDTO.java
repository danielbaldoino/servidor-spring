package com.example.servidor_spring.dto;

import com.example.servidor_spring.entity.Vehicle;
import com.example.servidor_spring.enums.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleDTO {
    private Long id;

    @NotBlank
    private String licensePlate;

    private String model;
    private String brand;
    private Integer year;
    private Double capacityKg;

    @NotNull
    private VehicleType vehicleType;

    public Vehicle toModel() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(this.id);
        vehicle.setLicensePlate(this.licensePlate);
        vehicle.setModel(this.model);
        vehicle.setBrand(this.brand);
        vehicle.setYear(this.year);
        vehicle.setCapacityKg(this.capacityKg);
        vehicle.setVehicleType(this.vehicleType);
        return vehicle;
    }
}
