package com.josh.home_maintenance_tracker.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotNull
    private String username;

    @NotNull
    private String passwordHash;

    @Column(unique = true)
    @NotNull
    // used to log in so needs to be unique
    private String email;

    private String phone;

    private String notificationPreference;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

    public User() {

    }

    // exclude timestamps in constructor since they're set automatically
    public User(String email, String firstName, String lastName, String notificationPreference, String passwordHash, String phone, String username) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notificationPreference = notificationPreference;
        this.passwordHash = passwordHash;
        this.phone = phone;
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(String notificationPreference) {
        this.notificationPreference = notificationPreference;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
