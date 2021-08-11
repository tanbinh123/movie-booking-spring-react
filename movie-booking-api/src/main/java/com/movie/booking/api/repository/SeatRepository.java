package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Seat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends PagingAndSortingRepository<Seat,Long> {
}
