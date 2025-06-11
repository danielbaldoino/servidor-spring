package com.example.servidor_spring.dto;

import com.example.servidor_spring.entity.Driver;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DriverDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    private String phone;

    @NotBlank
    private String licenseNumber;

    @NotNull
    private LocalDate licenseExpiration;

    public Driver toModel() {
        Driver driver = new Driver();
        driver.setId(this.id);
        driver.setName(this.name);
        driver.setCpf(this.cpf);
        driver.setPhone(this.phone);
        driver.setLicenseNumber(this.licenseNumber);
        driver.setLicenseExpiration(this.licenseExpiration);
        return driver;
    }
}
