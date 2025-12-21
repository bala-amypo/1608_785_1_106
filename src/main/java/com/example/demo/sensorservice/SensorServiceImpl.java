package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;

import java.util.List;

public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor getSensor(Long id) {
        Sensor sensor = sensorRepository.findById(id);
        if (sensor == null) {
            throw new ResourceNotFoundException("Sensor not found");
        }
        return sensor;
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}
