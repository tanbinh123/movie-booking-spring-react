package com.movie.booking.api.controller;

import com.movie.booking.api.model.AuditoriumModel;
import com.movie.booking.api.service.AuditoriumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/auditoriums")
@AllArgsConstructor
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    //Request GET : /api/auditoriums
    @GetMapping
    public Collection<AuditoriumModel> getAuditoriums (){
        return auditoriumService.getAuditoriums();
    }

    //Request POST : /api/auditoriums
    @PostMapping
    public AuditoriumModel addAuditorium(@RequestBody AuditoriumModel auditoriumModel){
        return auditoriumService.addAuditorium(auditoriumModel);
    }

    //Request DELETE : /api/auditoriums
    @DeleteMapping("/{id}")
    public void removeAuditorium(@PathVariable("id") Long id){
        auditoriumService.removeAuditorium(auditoriumService.getAuditorium(id));
    }
}
