package com.josh.home_maintenance_tracker.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "homes")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne // foreign key to id in users table
    @JoinColumn(name = "user_id", nullable = false) // actual column name
    private User user; // mapped to a User object

    private String state;

    private String propertyType;

    private int yearBuilt;

    private int squareFootage;

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

    public Home() {

    }

    public Home(String propertyType, int squareFootage, String state, User user, int yearBuilt) {
        this.propertyType = propertyType;
        this.squareFootage = squareFootage;
        this.state = state;
        this.user = user;
        this.yearBuilt = yearBuilt;
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

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}
