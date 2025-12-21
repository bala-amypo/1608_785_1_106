package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;

import java.util.List;

public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {

    private final ComplianceThresholdRepository thresholdRepository;

    public ComplianceThresholdServiceImpl(
            ComplianceThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }

    public ComplianceThreshold createThreshold(ComplianceThreshold threshold) {

        if (threshold.getMinValue() >= threshold.getMaxValue()) {
            throw new IllegalArgumentException("minvalue");
        }

        if (threshold.getSeverityLevel() == null) {
            throw new IllegalArgumentException("severityLevel");
        }

        return thresholdRepository.save(threshold);
    }

    public ComplianceThreshold getThreshold(Long id) {
        return thresholdRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Threshold not found"));
    }

    public ComplianceThreshold getThresholdBySensorType(String sensorType) {
        return thresholdRepository.findBySensorType(sensorType)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Threshold not found"));
    }

    public List<ComplianceThreshold> getAllThresholds() {
        return thresholdRepository.findAll();
    }
}
