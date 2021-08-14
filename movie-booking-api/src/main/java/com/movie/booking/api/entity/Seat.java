package com.movie.booking.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seats")
public class Seat {

    //We use backtick on @Column because [row] and [row_number] are MySQL reserved words.
    //Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds
    //to your MySQL server version for the right syntax to use near '-booking' at line 1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`row`", nullable = false)
    private Integer row;

    @Column(name = "`row_number`", nullable = false)
    private Integer rowNumber;

    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    @JsonBackReference(value = "auditorium_seats")
    private Auditorium auditorium;

}