package com.example.heliosspringboot.lesson24;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.heliosspringboot.lesson24.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/packages")
public class PackageController {

    private final PackageService service;

    public PackageController(PackageService service) {
        this.service = service;
    }

    // 1️⃣ POST – Yeni bağlama yaratmaq
    @PostMapping
    public ResponseEntity<PackageDto> create(
            @RequestBody PackageDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    // 2️⃣ GET – Tracking code ilə tapmaq
    @GetMapping("/{trackingCode}")
    public ResponseEntity<PackageDto> getByTrackingCode(
            @PathVariable UUID trackingCode) {

        return ResponseEntity.ok(
                service.findByTrackingCode(trackingCode));
    }

    // 3️⃣ PATCH – Status yeniləmək
    @PatchMapping("/{trackingCode}/status")
    public ResponseEntity<PackageDto> updateStatus(
            @PathVariable UUID trackingCode,
            @RequestParam PackageStatus status) {

        return ResponseEntity.ok(
                service.updateStatus(trackingCode, status));
    }
}
