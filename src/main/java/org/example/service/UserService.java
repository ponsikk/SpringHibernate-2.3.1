package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    void updateUserDetails(Long id, String name, String lastName, String email);
}
