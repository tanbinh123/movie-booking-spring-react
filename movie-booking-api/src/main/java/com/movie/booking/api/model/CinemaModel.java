package com.movie.booking.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CinemaModel {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private ManagerModel manager;
}
