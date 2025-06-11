package com.example.servidor_spring.repository;

import com.example.servidor_spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {}
