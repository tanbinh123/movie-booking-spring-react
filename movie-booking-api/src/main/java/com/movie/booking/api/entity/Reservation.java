package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservations")
public class Reservation extends Person {

    //Reservation :
    //Reserve seats from a screening
    //Date is used for order purposes only

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    @JsonManagedReference(value = "")
    private Screening screening;

    @ManyToMany
    @JoinTable(
            name = "reservation_seats",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id"))
    @JsonManagedReference
    private Collection<Seat> seats;


    @JsonProperty("reservation_date")
    @Column(name="reservation_date")
    private LocalDateTime reservationDate = LocalDateTime.now();

}