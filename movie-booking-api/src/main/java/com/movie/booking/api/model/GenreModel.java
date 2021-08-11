package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenreModel {
    private Long id;
    private String name;
    @JsonIgnore
    private List<MovieModel> movies = new ArrayList<>();
}
