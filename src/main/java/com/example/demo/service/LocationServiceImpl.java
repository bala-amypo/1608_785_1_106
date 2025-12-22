package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location create(Location location) {
        return repository.save(location);
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }

    @Override
    public Location getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @Override
    public Location update(Long id, Location location) {
        Location existing = getById(id);
        existing.setName(location.getName());
        existing.setRegion(location.getRegion());
        existing.setDescription(location.getDescription());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
