package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
}
