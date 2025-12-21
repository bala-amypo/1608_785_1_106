package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;

import java.time.LocalDateTime;
import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(Location location) {
        if (location.getRegion() == null || location.getRegion().isEmpty()) {
            throw new IllegalArgumentException("region required");
        }
        location.setCreatedAt(LocalDateTime.now());
        return locationRepository.save(location);
    }

    @Override
    public Location getLocation(Long id) {
        Location loc = locationRepository.findById(id);
        if (loc == null) {
            throw new ResourceNotFoundException("Location not found");
        }
        return loc;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
