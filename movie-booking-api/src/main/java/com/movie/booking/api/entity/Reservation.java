package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private SeatReserved seatReserved;

    @JsonProperty("reservation_date")
    @Column(name="reservation_date")
    @Temporal(TemporalType.DATE)
    private Date reservationDate;

    @ManyToOne
    private User user;

}