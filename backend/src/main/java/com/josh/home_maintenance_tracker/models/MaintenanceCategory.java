package com.josh.home_maintenance_tracker.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "maintenance_categories") // plural table name
public class MaintenanceCategory {

    @Id // indicates primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment id
    private Integer id;

    @Column(unique = true) // unique constraint
    @NotNull // cannot be null
    private String category;

    // empty constructor for database
    public MaintenanceCategory() {

    }

    public MaintenanceCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }
}
