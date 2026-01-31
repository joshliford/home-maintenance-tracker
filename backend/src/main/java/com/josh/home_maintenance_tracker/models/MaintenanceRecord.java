package com.josh.home_maintenance_tracker.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance_records")
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne // foreign key to id in maintenance_items table
    @JoinColumn(name = "maintenance_item_id", nullable = false)
    private MaintenanceItem maintenanceItem; // mapped to MaintenanceItem object (one MaintenanceItem can have many records)

    private String notes;

    // use BigDecimal for exact decimal precision
    private BigDecimal cost;

    private String completedBy;

    private LocalDateTime completedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public MaintenanceRecord() {

    }

    // include completedAt when creating a maintenance record
    public MaintenanceRecord(BigDecimal cost, MaintenanceItem maintenanceItem, String notes, String completedBy, LocalDateTime completedAt) {
        this.cost = cost;
        this.maintenanceItem = maintenanceItem;
        this.notes = notes;
        this.completedBy = completedBy;
        this.completedAt = completedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public MaintenanceItem getMaintenanceItem() {
        return maintenanceItem;
    }

    public void setMaintenanceItem(MaintenanceItem maintenanceItem) {
        this.maintenanceItem = maintenanceItem;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
