package com.example.demo;

import com.example.demo.controller.LocationController;
import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.LocationRepositoryImpl;
import com.example.demo.service.LocationService;
import com.example.demo.service.impl.LocationServiceImpl;

public class DemoApplication {

    public static void main(String[] args) {

        LocationRepository repo = new LocationRepositoryImpl();
        LocationService service = new LocationServiceImpl(repo);
        LocationController controller = new LocationController(service);

        Location loc = new Location();
        loc.setLocationName("Chennai");
        loc.setDescription("Metro City");
        loc.setRegion("South");

        Location saved = controller.create(loc);
        System.out.println("Created: " + saved.getId());

        Location fetched = controller.getById(1L);
        System.out.println("Fetched: " + fetched.getLocationName());

        System.out.println("Total Locations: " + controller.getAll().size());
    }
}
