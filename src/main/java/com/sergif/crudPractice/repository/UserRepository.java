package com.sergif.crudPractice.repository;

import com.sergif.crudPractice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}