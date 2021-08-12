package com.movie.booking.api.controller;

import com.movie.booking.api.model.AuditoriumModel;
import com.movie.booking.api.model.MovieModel;
import com.movie.booking.api.service.AuditoriumService;
import com.movie.booking.api.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public Collection<MovieModel> getAuditoriums (){
        return movieService.getMovies();
    }

    @PostMapping
    public MovieModel addAuditorium(@RequestBody MovieModel movieModel){
        return movieService.addMovie(movieModel);
    }

    @DeleteMapping("/{id}")
    public void removeAuditorium(@PathVariable("id") Long id){
        movieService.removeMovie(movieService.getMovie(id));
    }
}
