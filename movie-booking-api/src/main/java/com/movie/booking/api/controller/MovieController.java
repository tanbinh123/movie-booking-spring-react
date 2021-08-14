package com.movie.booking.api.controller;

import com.movie.booking.api.model.AuditoriumModel;
import com.movie.booking.api.model.MovieModel;
import com.movie.booking.api.model.ScreeningModel;
import com.movie.booking.api.service.AuditoriumService;
import com.movie.booking.api.service.MovieService;
import com.movie.booking.api.service.ScreeningService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ScreeningService screeningService;

    //Request GET : /api/movies/{id}
    @GetMapping("/{id}")
    public MovieModel getMovie (@PathVariable("id") Long id){
        return movieService.getMovie(id);
    }

    //Request GET : /api/movies
    @GetMapping
    public Collection<MovieModel> getMovies (){
        return movieService.getMovies();
    }

    //Request POST : /api/movies
    @PostMapping
    public MovieModel addMovie(@RequestBody MovieModel movieModel){
        return movieService.addMovie(movieModel);
    }

    //Request DELETE : /api/movies/{id}
    @DeleteMapping("/{id}")
    public void removeMovie(@PathVariable("id") Long id){
        movieService.removeMovie(movieService.getMovie(id));
    }

    //Request GET : /api/movies/{id}/screenings
    @GetMapping("/{id}/screenings")
    public Collection<ScreeningModel> getMovieScreenings(@PathVariable("id") Long id){
        return screeningService.getScreenings().stream().filter(screeningModel -> screeningModel.getMovie().getId()==id).collect(Collectors.toList());
    }
}
