package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends PagingAndSortingRepository<Reservation,Long> {
}
