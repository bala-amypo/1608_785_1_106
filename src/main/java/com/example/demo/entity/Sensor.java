package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sensorCode;

    private String sensorType;
    private LocalDateTime installedAt;
    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "sensor")
    private List<SensorReading> readings;

    public Sensor() {}

    public Sensor(String sensorCode, String sensorType, Location location,
                  LocalDateTime installedAt, Boolean isActive) {
        this.sensorCode = sensorCode;
        this.sensorType = sensorType;
        this.location = location;
        this.installedAt = installedAt;
        this.isActive = isActive;
    }
    // getters & setters
}
