package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;


    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    public User getUserById(Long id) {
        return userDao.findUserById(id);
    }

    public void createUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void updateUserDetails(Long id, String name, String lastName, String email) {
        User user = userDao.findUserById(id);
        if (user != null) {
            user.setFirstName(name);
            user.setLastName(lastName);
            user.setEmail(email);
            userDao.updateUser(user);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
    }

    public void deleteUser(Long id) {
        userDao.deleteUserById(id);
    }
}