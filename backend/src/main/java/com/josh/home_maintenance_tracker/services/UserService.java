package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.models.User;
import com.josh.home_maintenance_tracker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
5 operations:
getAllUsers()
getUserById(int id)
createUser(User user)
updateUser(int id, User user)
deleteUser(int id)
*/

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now()); // set createdAt since we're creating a new user
        return userRepository.save(user);
    }

    public User updateUser(int id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) { // TODO: throw exception
            return null;
        }
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setNotificationPreference(updatedUser.getNotificationPreference());
        existingUser.setUpdatedAt(LocalDateTime.now()); // set updatedAt since we're updating an existing user
        return userRepository.save(existingUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
