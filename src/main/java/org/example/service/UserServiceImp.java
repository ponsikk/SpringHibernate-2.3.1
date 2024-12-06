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
        User existingUser = userDao.findUserById(user.getId());
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found with ID: " + user.getId());
        }

        if (user.getFirstName() != null) {
            existingUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            existingUser.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        userDao.updateUser(existingUser);
    }


    public void deleteUser(Long id) {
        userDao.deleteUserById(id);
    }
}