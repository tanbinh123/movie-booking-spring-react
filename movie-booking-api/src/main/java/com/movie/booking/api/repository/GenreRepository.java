package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Genre;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends PagingAndSortingRepository<Genre,Long> {

}
