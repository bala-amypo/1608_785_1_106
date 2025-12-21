package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;

import java.util.List;

public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // POST
    public Location create(Location location) {
        return locationService.createLocation(location);
    }

    // GET by id
    public Location getById(Long id) {
        return locationService.getLocation(id);
    }

    // GET all
    public List<Location> getAll() {
        return locationService.getAllLocations();
    }
}
