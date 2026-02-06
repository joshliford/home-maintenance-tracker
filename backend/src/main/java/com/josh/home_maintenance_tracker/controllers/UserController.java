package com.josh.home_maintenance_tracker.controllers;

import com.josh.home_maintenance_tracker.models.User;
import com.josh.home_maintenance_tracker.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
5 endpoints:
GET /api/users (get all users)
GET /api/users/{userId} (get user by ID)
POST /api/users (create new user)
PUT /api/users/{userId} (update existing user by ID)
DELETE /api/users/{userId} (delete user by ID)
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
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }

}
