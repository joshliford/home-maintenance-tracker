package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.MaintenanceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceItemRepository extends JpaRepository<MaintenanceItem, Integer> {
}
