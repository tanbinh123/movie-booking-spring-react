package com.movie.booking.api.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatReservedModel {
    private Long id;
    private SeatModel seat;
    private ReservationModel reservation;
    private ScreeningModel screening;
}
