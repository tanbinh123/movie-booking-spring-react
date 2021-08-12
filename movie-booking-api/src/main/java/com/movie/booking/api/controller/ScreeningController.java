package com.movie.booking.api.controller;

import com.movie.booking.api.model.ScreeningModel;
import com.movie.booking.api.service.ScreeningService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/screenings")
@AllArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping
    public Collection<ScreeningModel> getScreenings (){
        return screeningService.getScreenings();
    }

    @PostMapping
    public ScreeningModel addCinema(@RequestBody ScreeningModel screeningModel){
        return screeningService.addScreening(screeningModel);
    }

    @DeleteMapping("/{id}")
    public void removeScreening(@PathVariable("id") Long id){
        screeningService.removeScreening(screeningService.getScreening(id));
    }

}
