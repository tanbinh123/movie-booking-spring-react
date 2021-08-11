package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieModel {
    private Long id;
    private String title;
    private String poster;
    @JsonProperty("imdb_rating")
    private String imdbRating;
    @JsonProperty("release_date")
    private String releaseDate;
    private String description;
    private String runtime;
    private List<GenreModel> genres;
}
