package com.example.demo.entity;

public class SensorReading {

    private Long id;
    private Sensor sensor;
    private Double readingValue;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Sensor getSensor() { return sensor; }
    public void setSensor(Sensor sensor) { this.sensor = sensor; }

    public Double getReadingValue() { return readingValue; }
    public void setReadingValue(Double readingValue) { this.readingValue = readingValue; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
