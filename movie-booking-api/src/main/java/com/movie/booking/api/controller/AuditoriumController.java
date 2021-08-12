package com.movie.booking.api.controller;

import com.movie.booking.api.model.AuditoriumModel;
import com.movie.booking.api.model.CinemaModel;
import com.movie.booking.api.model.SeatModel;
import com.movie.booking.api.service.AuditoriumService;
import com.movie.booking.api.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/auditoriums")
@AllArgsConstructor
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    @GetMapping
    public Collection<AuditoriumModel> getAuditoriums (){
        return auditoriumService.getAuditoriums();
    }

    @PostMapping
    public AuditoriumModel addAuditorium(@RequestBody AuditoriumModel auditoriumModel){
        return auditoriumService.addAuditorium(auditoriumModel);
    }

    @DeleteMapping("/{id}")
    public void removeAuditorium(@PathVariable("id") Long id){
        auditoriumService.removeAuditorium(auditoriumService.getAuditorium(id));
    }
}
