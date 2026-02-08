package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.MaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Integer> {
    // custom query
    List<MaintenanceRecord> findByMaintenanceItemId(Integer maintenanceItemId);
}
