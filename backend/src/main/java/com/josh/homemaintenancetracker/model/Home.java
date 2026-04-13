package com.josh.homemaintenancetracker.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "homes")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // foreign key to User entity
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // store 2 letter abbreviation for state
    @Column(length = 2)
    private String state;

    private Integer yearBuilt;

    private Double squareFootage;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Home () {

    }

    public Home(PropertyType propertyType, double squareFootage, String state, User user, Integer yearBuilt) {
        this.propertyType = propertyType;
        this.squareFootage = squareFootage;
        this.state = state;
        this.user = user;
        this.yearBuilt = yearBuilt;
    }

    public Integer getId() {
        return id;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
