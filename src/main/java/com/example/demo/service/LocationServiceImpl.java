package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location create(Location location) {
        if (location.getName() == null || location.getName().isEmpty()) {
            throw new IllegalArgumentException("Name required");
        }
        return repository.save(location);
    }

    @Override
    public Location get(int id) {
        Location loc = repository.findById(id);
        if (loc == null) {
            throw new ResourceNotFoundException("Location not found");
        }
        return loc;
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
