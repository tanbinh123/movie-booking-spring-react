package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String poster;

    @Column(name = "imdb_rating")
    @JsonProperty("imdb_rating")
    private String imdbRating;

    @Column(name = "release_date")
    @JsonProperty("release_date")
    private String releaseDate;

    @Column
    private String description;

    @Column
    private String runtime;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Genre> genres;


}