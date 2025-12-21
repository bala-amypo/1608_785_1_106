package com.example.demo.repository;

import com.example.demo.entity.Sensor;
import java.util.List;

public interface SensorRepository {

    Sensor save(Sensor sensor);
    Sensor findById(Long id);
    List<Sensor> findAll();
}
