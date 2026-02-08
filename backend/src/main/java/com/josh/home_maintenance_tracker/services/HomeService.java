package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.models.Home;
import com.josh.home_maintenance_tracker.repositories.HomeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
5 operations:
getAllHomes()
getHomeById(int id)
createHome(Home home)
updateHome(int id, Home home)
deleteHome(int id)
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
        return homeRepository.findById(id).orElse(null);
    }

    public Home createHome(Home home) {
        home.setCreatedAt(LocalDateTime.now());
        return homeRepository.save(home);
    }

    public Home updateHome(Integer id, Home updatedHome) {
        Home existingHome = homeRepository.findById(id).orElse(null);
        if (existingHome == null) {
            return null; // TODO: throw exception
        }
        existingHome.setState(updatedHome.getState());
        existingHome.setPropertyType(updatedHome.getPropertyType());
        existingHome.setSquareFootage(updatedHome.getSquareFootage());
        existingHome.setUpdatedAt(LocalDateTime.now());
        return homeRepository.save(existingHome);
    }

    public void deleteHome(Integer id) {
        homeRepository.deleteById(id);
    }

}
