package com.example.demo.repository;

import com.example.demo.entity.Location;
import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryImpl implements LocationRepository {

    private List<Location> db = new ArrayList<>();
    private long idCounter = 1;

    @Override
    public Location save(Location location) {
        location.setId(idCounter++);
        db.add(location);
        return location;
    }

    @Override
    public Location findById(Long id) {
        for (Location l : db) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Location> findAll() {
        return db;
    }
}
