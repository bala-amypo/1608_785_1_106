package com.example.demo.repository;

import com.example.demo.entity.Location;
import java.util.List;

public interface LocationRepository {
    Location save(Location location);
    Location findById(Long id);
    List<Location> findAll();
}
