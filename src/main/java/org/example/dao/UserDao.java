package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUsers();  // Переименовано в findAllUsers()
    User findUserById(Long id);  // Переименовано в findUserById()
    void saveUser(User user);    // Переименовано в saveUser()
    void updateUser(User user);  // Переименовано в updateUser()
    void deleteUserById(Long id); // Переименовано в deleteUserById()
}
