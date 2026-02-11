package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.Reminder;
import com.josh.home_maintenance_tracker.services.ReminderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
7 endpoints:
GET /api/reminders (get all reminders)
GET /api/reminders/{reminderId} (get reminder by ID)
POST /api/reminders (create reminder)
PUT /api/reminders/{reminderId} (update reminder)
DELETE /api/reminders/{reminderId} (delete reminder)
GET /api/reminders/maintenence-items/{maintenanceItemId} (get reminders by maintenanceItemId)
GET /api/reminders/status/{status} (get reminders by status)
*/

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("")
    public List<Reminder> getAllReminders() {
        return reminderService.getAllReminders();
    }

    @GetMapping("/{reminderId}")
    public Reminder getReminderById(@PathVariable Integer reminderId) {
        return reminderService.getReminderById(reminderId);
    }

    @PostMapping
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderService.createReminder(reminder);
    }

    @PutMapping("/{reminderId}")
    public Reminder updateReminder(@PathVariable Integer reminderId, @RequestBody Reminder reminder) {
        return reminderService.updateReminder(reminderId, reminder);
    }

    @DeleteMapping("/{reminderId}")
    public void deleteReminder(@PathVariable Integer reminderId) {
        reminderService.deleteReminder(reminderId);
    }

    // custom endpoints
    @GetMapping("/maintenance-items/{maintenanceItemId}")
    public List<Reminder> getRemindersByMaintenanceItemId(@PathVariable Integer maintenanceItemId) {
        return reminderService.getRemindersByMaintenanceItemId(maintenanceItemId);
    }

    @GetMapping("/status/{status}")
    public List<Reminder> getRemindersByStatus(@PathVariable String status) {
        return reminderService.findRemindersByStatus(status);
    }


}
