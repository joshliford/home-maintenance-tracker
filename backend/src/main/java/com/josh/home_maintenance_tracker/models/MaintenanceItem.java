package com.josh.home_maintenance_tracker.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;



@Entity
@Table(name = "maintenance_items")
public class MaintenanceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne // foreign key to id in homes table
    @JoinColumn(name = "home_id", nullable = false)
    private Home home; // mapped to Home object (many items can belong to one home)

    @ManyToOne // foreign key to id in maintenance_categories table
    @JoinColumn(name = "category_id", nullable = false)
    private MaintenanceCategory category; // mapped to MaintenanceCategory object (many items can share one category)

    private String description;

    private String model;

    private String serialNumber;

    private int yearInstalled;

    private int maintenanceFrequencyDays;

    private String notes;

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

    public MaintenanceItem() {

    }

    public MaintenanceItem(MaintenanceCategory category, String description, Home home, int maintenanceFrequencyDays, String model, String notes, String serialNumber, int yearInstalled) {
        this.category = category;
        this.description = description;
        this.home = home;
        this.maintenanceFrequencyDays = maintenanceFrequencyDays;
        this.model = model;
        this.notes = notes;
        this.serialNumber = serialNumber;
        this.yearInstalled = yearInstalled;
    }

    public MaintenanceCategory getCategory() {
        return category;
    }

    public void setCategory(MaintenanceCategory category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public int getId() {
        return id;
    }

    public int getMaintenanceFrequencyDays() {
        return maintenanceFrequencyDays;
    }

    public void setMaintenanceFrequencyDays(int maintenanceFrequencyDays) {
        this.maintenanceFrequencyDays = maintenanceFrequencyDays;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getYearInstalled() {
        return yearInstalled;
    }

    public void setYearInstalled(int yearInstalled) {
        this.yearInstalled = yearInstalled;
    }
}
