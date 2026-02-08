package com.josh.home_maintenance_tracker.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne // foreign key to id in maintenance_items table
    @JoinColumn(name = "maintenance_item_id", nullable = false)
    private MaintenanceItem maintenanceItem; // mapped to MaintenanceItem object (one MaintenanceItem can have many reminders)

    private LocalDateTime dueDate;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime sentAt;

    public Reminder () {

    }

    // createdAt and sentAt are not provided by the user - they are auto-set at the time of creation
    public Reminder(LocalDateTime dueDate, MaintenanceItem maintenanceItem, String status) {
        this.dueDate = dueDate;
        this.maintenanceItem = maintenanceItem;
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public MaintenanceItem getMaintenanceItem() {
        return maintenanceItem;
    }

    public void setMaintenanceItem(MaintenanceItem maintenanceItem) {
        this.maintenanceItem = maintenanceItem;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }
}
