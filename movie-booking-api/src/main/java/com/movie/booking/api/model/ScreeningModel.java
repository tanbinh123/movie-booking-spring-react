package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScreeningModel {
    private Long id;
    private MovieModel movie;
    private AuditoriumModel auditorium;
    @JsonProperty("screening_date")
    private LocalDateTime screeningDate;
}
