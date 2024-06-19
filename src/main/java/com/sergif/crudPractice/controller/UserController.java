package com.sergif.crudPractice.controller;

import com.sergif.crudPractice.dto.UserRequest;
import com.sergif.crudPractice.dto.UserResponse;
import com.sergif.crudPractice.model.User;
import com.sergif.crudPractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest user) {
        return userService.updateUser(id, user);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
