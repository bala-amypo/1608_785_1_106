package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_thresholds")
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorType;
    private Double minValue;
    private Double maxValue;
    private String severityLevel;
    private LocalDateTime createdAt;

    public ComplianceThreshold() {}

    public ComplianceThreshold(String sensorType, Double minValue,
                               Double maxValue, String severityLevel,
                               LocalDateTime createdAt) {
        this.sensorType = sensorType;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.severityLevel = severityLevel;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getSensorType() { return sensorType; }
    public Double getMinValue() { return minValue; }
    public Double getMaxValue() { return maxValue; }
}
