package com.sergif.crudPractice.service;

import com.sergif.crudPractice.dto.MovieRequest;
import com.sergif.crudPractice.dto.MovieResponse;
import com.sergif.crudPractice.model.Movie;
import com.sergif.crudPractice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> movie =  movieRepository.findById(id);
        return movie.orElse(null);
    }

    @Override
    public MovieResponse updateMovie(Long id, MovieRequest movieRequest) {
        MovieResponse movieResponse = new MovieResponse();

        Movie movie = getMovieById(id);

        if (movie != null){
            movie.setOriginal_title(movieRequest.getOriginal_title());
            movie.setUpdatedAt(new Timestamp(System.currentTimeMillis()));


            Movie movieUpdated = movieRepository.save(movie);
            movieResponse.setId(movieUpdated.getId());
            movieResponse.setOriginal_title(movieUpdated.getOriginal_title());
        }

        return movieResponse;
    }

    @Override
    public MovieResponse createMovie(MovieRequest movieRequest) {
        MovieResponse movieResponse = new MovieResponse();

        Movie movie = new Movie();

        movie.setOriginal_title(movieRequest.getOriginal_title());
        movie.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        movie.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        Movie movieCreated = movieRepository.save(movie);
        movieResponse.setId(movieCreated.getId());
        movieResponse.setOriginal_title(movieCreated.getOriginal_title());

        return movieResponse;
    }

    @Override
    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
