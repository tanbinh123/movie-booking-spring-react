package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Cinema;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends PagingAndSortingRepository<Cinema, Long> {
}
