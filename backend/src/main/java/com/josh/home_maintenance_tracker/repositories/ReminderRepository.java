package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
    List<Reminder> findRemindersByMaintenanceItemId(Integer maintenanceItemId);
    List<Reminder> findRemindersByStatus(String status);
}
