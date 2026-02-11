package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.exceptions.ResourceNotFoundException;
import com.josh.home_maintenance_tracker.models.Reminder;
import com.josh.home_maintenance_tracker.repositories.ReminderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
5 operations + 2 custom filter methods:
getAllReminders()
getReminderById(Integer reminderId)
createReminder(Reminder reminder)
updateReminder(Integer reminderId, Reminder updatedReminder)
deleteReminder(Integer reminderId)
getRemindersByMaintenanceItemId(Integer maintenanceItemId)
getRemindersByStatus(String status)
*/

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public Reminder getReminderById(Integer reminderId) {
        return reminderRepository.findById(reminderId)
                .orElseThrow(() -> new ResourceNotFoundException("Reminder not found with id: " + reminderId));
    }

    public Reminder createReminder(Reminder reminder) {
        reminder.setCreatedAt(LocalDateTime.now());
        return reminderRepository.save(reminder);
    }

    public Reminder updateReminder(Integer reminderId, Reminder updatedReminder) {
        Reminder existingReminder = reminderRepository.findById(reminderId)
                        .orElseThrow(() -> new ResourceNotFoundException("Reminder not found with id: " + reminderId));
        existingReminder.setDueDate(updatedReminder.getDueDate());
        existingReminder.setStatus(updatedReminder.getStatus());
        existingReminder.setSentAt(updatedReminder.getSentAt());
        return reminderRepository.save(existingReminder);
    }

    public void deleteReminder(Integer reminderId) {
        Reminder existingReminder = reminderRepository.findById(reminderId)
                        .orElseThrow(() -> new ResourceNotFoundException("Reminder not found with id: " + reminderId));
        reminderRepository.delete(existingReminder);
    }

    // custom filter methods
    public List<Reminder> getRemindersByMaintenanceItemId(Integer maintenanceItemId) {
        return reminderRepository.findRemindersByMaintenanceItemId(maintenanceItemId);
    }

    public List<Reminder> findRemindersByStatus(String status) {
        return reminderRepository.findRemindersByStatus(status);
    }
}
