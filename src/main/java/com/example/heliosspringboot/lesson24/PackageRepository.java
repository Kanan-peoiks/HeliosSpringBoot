package com.example.heliosspringboot.lesson24;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PackageRepository
        extends JpaRepository<PackageEntity, Long> {

    Optional<PackageEntity> findByTrackingCode(UUID trackingCode);
}
