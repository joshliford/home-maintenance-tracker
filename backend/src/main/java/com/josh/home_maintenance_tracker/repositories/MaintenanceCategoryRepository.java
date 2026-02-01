package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.MaintenanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceCategoryRepository extends JpaRepository<MaintenanceCategory, Integer> {
}
