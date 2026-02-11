package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.exceptions.ResourceNotFoundException;
import com.josh.home_maintenance_tracker.models.Home;
import com.josh.home_maintenance_tracker.repositories.HomeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
5 operations:
getAllHomes()
getHomeById(Integer id)
createHome(Home home)
updateHome(Integer id, Home home)
deleteHome(Integer id)
*/

@Service
public class HomeService {

    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    public Home getHomeById(Integer id) {
        return homeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Home not found with id: " + id));
    }

    public Home createHome(Home home) {
        home.setCreatedAt(LocalDateTime.now());
        return homeRepository.save(home);
    }

    public Home updateHome(Integer id, Home updatedHome) {
        Home existingHome = homeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Home not found with id: " + id));
        existingHome.setState(updatedHome.getState());
        existingHome.setPropertyType(updatedHome.getPropertyType());
        existingHome.setSquareFootage(updatedHome.getSquareFootage());
        existingHome.setUpdatedAt(LocalDateTime.now());
        return homeRepository.save(existingHome);
    }

    public void deleteHome(Integer id) {
        Home existingHome = homeRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Home not found with id: " + id));
        homeRepository.delete(existingHome);
    }

}
