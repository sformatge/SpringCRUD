package com.sergif.crudPractice.service;

import com.sergif.crudPractice.dto.MovieRequest;
import com.sergif.crudPractice.dto.MovieResponse;
import com.sergif.crudPractice.model.Movie;

public interface MovieService {

    Iterable<Movie> getAllMovies();

    Movie getMovieById(Long id);

    MovieResponse updateMovie(Long id, MovieRequest movie);

    MovieResponse createMovie(MovieRequest movie);

    boolean deleteMovie(Long id);
}
