package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.MaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Integer> {
}
