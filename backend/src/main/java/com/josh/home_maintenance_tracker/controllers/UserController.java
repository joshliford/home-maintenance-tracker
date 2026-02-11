package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.User;
import com.josh.home_maintenance_tracker.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
5 endpoints:
GET /api/users (get all users)
GET /api/users/{userId} (get user by ID)
POST /api/users (create new user)
PUT /api/users/{userId} (update existing user)
DELETE /api/users/{userId} (delete user)
*/

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId, @Valid @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

}
