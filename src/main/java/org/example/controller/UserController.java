package org.example.controller;

import org.example.dao.UserDao;
import org.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "user-list";
    }


    @PostMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email) {
        userDao.save(new User(name, lastName, email));
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email) {
        User user = userDao.findById(id);
        if (user != null) {
            user.setFirstName(name);
            user.setLastName(lastName);
            user.setEmail(email);
            userDao.update(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}
