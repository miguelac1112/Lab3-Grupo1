package com.example.lab3.Repository;

import com.example.lab3.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface RegionRepository extends JpaRepository<Region, BigDecimal> {
}