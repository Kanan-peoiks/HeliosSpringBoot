package com.example.heliosspringboot.lesson24;

import org.springframework.stereotype.Service;
import com.example.heliosspringboot.lesson24.exception.ResourceNotFoundException;
import java.util.UUID;

@Service
public class PackageService {
    private final PackageRepository repository;

    public PackageService(PackageRepository repository) {
        this.repository = repository;
    }

    // 1️⃣ Yeni bağlama yaratmaq
    public PackageDto create(PackageDto dto) {
        PackageEntity entity = new PackageEntity();

        entity.setTrackingCode(UUID.randomUUID());
        entity.setStatus(PackageStatus.PENDING);
        entity.setReceiverName(dto.getReceiverName());

        repository.save(entity);
        return toDto(entity);
    }

    // 2️⃣ Tracking code ilə tapmaq
    public PackageDto findByTrackingCode(UUID code) {
        PackageEntity entity = repository
                .findByTrackingCode(code)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Package not found"));

        return toDto(entity);
    }

    // 3️⃣ Status yeniləmək
    public PackageDto updateStatus(UUID code, PackageStatus status) {
        PackageEntity entity = repository
                .findByTrackingCode(code)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Package not found"));

        entity.setStatus(status);
        repository.save(entity);

        return toDto(entity);
    }

    // 🔄 Entity → DTO
    private PackageDto toDto(PackageEntity entity) {
        PackageDto dto = new PackageDto();
        dto.setTrackingCode(entity.getTrackingCode());
        dto.setStatus(entity.getStatus());
        dto.setReceiverName(entity.getReceiverName());
        return dto;
    }
}

