package com.movie.booking.api.controller;

import com.movie.booking.api.model.CinemaModel;
import com.movie.booking.api.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/cinemas")
@AllArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    //Request GET : /api/cinemas
    @GetMapping
    public Collection<CinemaModel> getCinemas (){
        return cinemaService.getCinemas();
    }

    //Request POST : /api/cinemas
    @PostMapping
    public CinemaModel addCinema(@RequestBody CinemaModel cinemaModel){
        return cinemaService.addCinema(cinemaModel);
    }

    //Request DELETE : /api/cinemas
    @DeleteMapping("/{id}")
    public void removeCinema(@PathVariable("id") Long id){
        cinemaService.removeCinema(cinemaService.getCinema(id));
    }

}
