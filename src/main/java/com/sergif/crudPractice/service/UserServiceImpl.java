package com.sergif.crudPractice.service;

import com.sergif.crudPractice.dto.UserRequest;
import com.sergif.crudPractice.dto.UserResponse;
import com.sergif.crudPractice.model.User;
import com.sergif.crudPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user =  userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();

        User user = getUserById(id);

        if (user != null){
            user.setName(userRequest.getName());
            user.setAge(userRequest.getAge());
            user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));


            User userUpdated = userRepository.save(user);
            userResponse.setId(userUpdated.getId());
            userResponse.setName(userUpdated.getName());
            userResponse.setAge(userUpdated.getAge());
        }

        return userResponse;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();

        User user = new User();

        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        User userCreated = userRepository.save(user);
        userResponse.setId(userCreated.getId());
        userResponse.setName(userCreated.getName());
        userResponse.setAge(userCreated.getAge());

        return userResponse;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
