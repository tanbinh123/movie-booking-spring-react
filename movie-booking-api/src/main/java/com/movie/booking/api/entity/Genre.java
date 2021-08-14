package com.movie.booking.api.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //Relation many to many between movies and genres
    //One genre can have many movies
    //Bidirectional relationship
    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    @JsonBackReference(value = "movie_genres")
    private Collection<Movie> movies;
}