package com.josh.home_maintenance_tracker.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "homes")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne // foreign key to id in users table
    @JoinColumn(name = "user_id", nullable = false) // actual column name
    private User user; // mapped to a User object

    private String state;

    private String propertyType;

    // use the Integer wrapper class for columns that can contain null values
    // primitive int cannot contain null values so need to use Integer
    private Integer yearBuilt;

    private Integer squareFootage;

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

    public Home() {

    }

    public Home(String propertyType, Integer squareFootage, String state, User user, Integer yearBuilt) {
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

    public Integer getId() {
        return id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Integer squareFootage) {
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

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}
