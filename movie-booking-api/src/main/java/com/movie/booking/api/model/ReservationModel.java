package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.booking.api.entity.Person;
import com.movie.booking.api.entity.Screening;
import com.movie.booking.api.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationModel {
    private Long id;
    private ScreeningModel screening;
    private Collection<SeatModel> seats;
    @JsonProperty("reservation_date")
    private LocalDateTime reservationDate = LocalDateTime.now();
    //Client Info
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String phone;
    private String address;
    private String email;
}
