package com.movie.booking.api.controller;

import com.movie.booking.api.model.ReservationModel;
import com.movie.booking.api.model.ScreeningModel;
import com.movie.booking.api.service.ReservationService;
import com.movie.booking.api.service.ScreeningService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/screenings")
@AllArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;
    private final ReservationService reservationService;

    //Request GET : /api/screenings
    @GetMapping
    public Collection<ScreeningModel> getScreenings (){
        return screeningService.getScreenings();
    }

    //Request GET : /api/screenings/{id}
    @GetMapping("/{id}")
    public ScreeningModel getScreening (@PathVariable("id") Long id){
        return screeningService.getScreening(id);
    }

    //Request GET : /api/screenings/{id}/reservations
    //This return the reservations of a screening
    @GetMapping("/{id}/reservations")
    public Collection<ReservationModel> getScreeningReservations (@PathVariable("id") Long id){
        Collection<ReservationModel> reservations =  reservationService.getReservations();
        reservations = reservations.stream().filter(reservation -> reservation.getScreening().getId()==id).collect(Collectors.toList());
        return reservations;
    }

    //Request POST : /api/screenings
    @PostMapping
    public Collection<ScreeningModel> addScreenings(@RequestBody Collection<ScreeningModel> screeningModels){
        for(ScreeningModel screeningModel : screeningModels){
            screeningModel.setId(screeningService.addScreening(screeningModel).getId());
        }
        return screeningModels;
    }

    //Request DELETE : /api/screenings/{id}
    @DeleteMapping("/{id}")
    public void removeScreening(@PathVariable("id") Long id){
        screeningService.removeScreening(screeningService.getScreening(id));
    }

}
