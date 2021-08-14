package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.booking.api.entity.Screening;
import com.movie.booking.api.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationPostModel {
    private ScreeningModel screening;
    @JsonProperty("total_seats")
    private Integer totalSeats;
    //Client Info
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String phone;
    private String address;
    private String email;
}
