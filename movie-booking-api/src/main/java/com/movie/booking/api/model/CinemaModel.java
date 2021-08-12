package com.movie.booking.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.movie.booking.api.entity.Auditorium;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CinemaModel {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Collection<AuditoriumModel> auditoriums;

    @JsonManagedReference
    public Collection<AuditoriumModel> getAuditoriums() {
        return auditoriums;
    }
}
