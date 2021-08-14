package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(SeatReserved.class)
public class SeatReserved implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Id
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}