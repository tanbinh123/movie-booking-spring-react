package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.booking.api.entity.Auditorium;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatModel {
    private Long id;
    private Integer row;
    @JsonProperty("row_number")
    private Integer rowNumber;
    private AuditoriumModel auditorium;

    @JsonBackReference
    public AuditoriumModel getAuditorium() {
        return auditorium;
    }
}
