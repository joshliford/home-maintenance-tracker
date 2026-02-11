package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.Home;
import com.josh.home_maintenance_tracker.services.HomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
5 endpoints:
GET /api/homes (get all homes)
GET /api/homes/{homeId} (get home by ID)
POST /api/homes (create new home)
PUT /api/homes/{homeId} (update existing home)
DELETE /api/homes/{homeId} (delete home)
*/

@RestController
@RequestMapping("/api/homes")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("")
    public List<Home> getAllHomes() {
        return homeService.getAllHomes();
    }

    @GetMapping("/{homeId}")
    public Home getHomeById(@PathVariable Integer homeId) {
        return homeService.getHomeById(homeId);
    }

    @PostMapping
    public Home createHome(@RequestBody Home home) {
        return homeService.createHome(home);
    }

    @PutMapping("/{homeId}")
    public Home updateHome(@PathVariable Integer homeId, @RequestBody Home home) {
        return homeService.updateHome(homeId, home);
    }

    @DeleteMapping("/{homeId}")
    public void deleteHome(@PathVariable Integer homeId) {
        homeService.deleteHome(homeId);
    }

}
