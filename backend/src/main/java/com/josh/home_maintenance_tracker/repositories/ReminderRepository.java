package com.josh.home_maintenance_tracker.repositories;

import com.josh.home_maintenance_tracker.models.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
}
