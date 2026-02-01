package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
