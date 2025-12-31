package com.example.heliosspringboot.lesson24;

import java.util.UUID;

public class PackageDto {
    private UUID trackingCode;
    private PackageStatus status;
    private String receiverName;

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
