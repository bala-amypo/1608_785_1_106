package com.example.demo.repository;

import com.example.demo.entity.Location;
import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryImpl implements LocationRepository {

    private final List<Location> db = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public synchronized Location save(Location location) {
        location.setId(idCounter++);
        db.add(location);
        return location;
    }

    @Override
    public synchronized Location findById(int id) {
        for (Location l : db) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    @Override
    public synchronized List<Location> findAll() {
        return db;
    }

    @Override
    public synchronized void deleteById(int id) {
        db.removeIf(l -> l.getId() == id);
    }
}
