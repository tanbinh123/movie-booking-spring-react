package com.movie.booking.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationModel {
    private Long id;
    private SeatReservedModel seatReserved;
    private LocalDateTime timestamp;
    private UserModel user;
}
