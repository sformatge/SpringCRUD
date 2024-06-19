package com.sergif.crudPractice.controller;

import com.sergif.crudPractice.dto.MovieRequest;
import com.sergif.crudPractice.dto.MovieResponse;
import com.sergif.crudPractice.service.MovieService;
import com.sergif.crudPractice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public MovieResponse updateMovie(@PathVariable Long id, @RequestBody MovieRequest movie) {
        return movieService.updateMovie(id, movie);
    }

    @PostMapping
    public MovieResponse createMovie(@RequestBody MovieRequest movie) {
        return movieService.createMovie(movie);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
