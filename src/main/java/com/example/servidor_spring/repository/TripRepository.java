package com.example.servidor_spring.repository;

import com.example.servidor_spring.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {}
