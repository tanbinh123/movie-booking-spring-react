package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="auditoriums")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //Relation many to one between cinema and auditoriums
    //One cinema can have many auditoriums
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cinema_id")
    @JsonBackReference(value = "cinema_auditorium")
    private Cinema cinema;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "auditorium_seats")
    private Collection<Seat> seats;

}