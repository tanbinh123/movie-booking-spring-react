package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
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

    //Poster picture URL
    @Column(columnDefinition="TEXT")
    private String poster;

    @Column(name = "imdb_rating")
    @JsonProperty("imdb_rating")
    private String imdbRating;

    @Column(name = "release_date")
    @JsonProperty("release_date")
    private String releaseDate;

    //Synopsis
    @Column(columnDefinition="TEXT")
    private String description;

    @Column
    private String runtime;

    //Relation many to many between movies and genres
    //One movie can have many movies
    //Bidirectional relationship
    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonManagedReference(value = "movie_genres")
    private Collection<Genre> genres;

}