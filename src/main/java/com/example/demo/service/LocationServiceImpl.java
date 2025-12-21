package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location getLocation(Long id) {
        Location location = locationRepository.findById(id);
        if (location == null) {
            throw new ResourceNotFoundException("Location not found");
        }
        return location;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
