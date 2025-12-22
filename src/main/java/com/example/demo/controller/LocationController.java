package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
    public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    public Location create(Location location) {
        return service.create(location);
    }

    public Location getById(int id) {
        return service.get(id);
    }

    public List<Location> getAll() {
        return service.getAll();
    }

    public String delete(int id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
