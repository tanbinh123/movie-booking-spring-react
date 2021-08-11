package com.movie.booking.api.model;

import com.movie.booking.api.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditoriumModel {
    private Long id;
    private String name;
    private Set<SeatModel> seats;
}
