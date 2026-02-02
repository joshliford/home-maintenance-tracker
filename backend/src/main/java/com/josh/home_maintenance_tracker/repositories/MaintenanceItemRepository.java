package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.MaintenanceItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceItemRepository extends JpaRepository<MaintenanceItem, Integer> {
    // custom queries for maintenance items
    List<MaintenanceItem> findByHomeId(int homeId);
    List<MaintenanceItem> findByCategoryId(int categoryId);
}
