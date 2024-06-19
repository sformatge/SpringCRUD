package com.sergif.crudPractice.repository;

import com.sergif.crudPractice.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
