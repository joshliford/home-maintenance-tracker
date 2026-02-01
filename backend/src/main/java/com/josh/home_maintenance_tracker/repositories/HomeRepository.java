package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Integer> {
}
