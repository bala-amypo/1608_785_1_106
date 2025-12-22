package com.example.demo.service;

import com.example.demo.entity.Location;
import java.util.List;

public interface LocationService {

    Location create(Location location);
    List<Location> getAll();
    Location getById(Long id);
    Location update(Long id, Location location);
    void delete(Long id);
}
