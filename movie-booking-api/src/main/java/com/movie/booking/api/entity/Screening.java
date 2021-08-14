package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="screenings")
public class Screening {

    //Screening :
    //A movie in a Auditorium at a certain moment of time

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference(value = "screening_movie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    @JsonBackReference(value = "screening_auditorium")
    private Auditorium auditorium;

    @Column(name="screening_date")
    @JsonProperty("screening_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime screeningDate;
}