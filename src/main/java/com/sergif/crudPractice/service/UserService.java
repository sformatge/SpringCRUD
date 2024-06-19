package com.sergif.crudPractice.service;

import com.sergif.crudPractice.dto.UserRequest;
import com.sergif.crudPractice.dto.UserResponse;
import com.sergif.crudPractice.model.User;

public interface UserService {

    User getUserById(Long id);

    Iterable<User> getAllUsers();

    UserResponse updateUser(Long id, UserRequest user);

    UserResponse createUser(UserRequest user);

    boolean deleteUser(Long id);
}
