package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Person {

    @Column(nullable = false)
    @JsonProperty("first_name")
    private String firstName;

    @Column(nullable = false)
    @JsonProperty("last_name")
    private String lastName;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String email;

}