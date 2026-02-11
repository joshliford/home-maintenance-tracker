package com.josh.home_maintenance_tracker.services;

import com.josh.home_maintenance_tracker.exceptions.ResourceNotFoundException;
import com.josh.home_maintenance_tracker.models.User;
import com.josh.home_maintenance_tracker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
5 operations:
getAllUsers()
getUserById(Integer id)
createUser(User user)
updateUser(Integer id, User updatedUser)
deleteUser(Integer id)
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

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now()); // set createdAt since we're creating a new user
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " +id));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setNotificationPreference(updatedUser.getNotificationPreference());
        existingUser.setUpdatedAt(LocalDateTime.now()); // set updatedAt since we're updating an existing user
        return userRepository.save(existingUser);
    }

    public void deleteUser(Integer id) {
        User existingUser = userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(existingUser); // use .delete() rather than .deleteById() since we're using a User object for the exception check
    }

}
