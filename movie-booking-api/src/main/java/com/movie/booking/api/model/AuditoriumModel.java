package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movie.booking.api.entity.Cinema;
import com.movie.booking.api.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditoriumModel {
    private Long id;
    private String name;
    private CinemaModel cinema;
    private Collection<SeatModel> seats;

    @JsonManagedReference
    public Collection<SeatModel> getSeats() {
        return seats;
    }

    @JsonBackReference
    public CinemaModel getCinema() {
        return cinema;
    }
}
