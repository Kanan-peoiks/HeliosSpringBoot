package com.example.heliosspringboot.lesson24;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "packages")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID trackingCode;

    @Enumerated(EnumType.STRING)
    private PackageStatus status;

    private String receiverName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(UUID trackingCode) {
        this.trackingCode = trackingCode;
    }

    public PackageStatus getStatus() {
        return status;
    }

    public void setStatus(PackageStatus status) {
        this.status = status;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}

