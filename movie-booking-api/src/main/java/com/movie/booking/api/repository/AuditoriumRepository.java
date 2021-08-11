package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Auditorium;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends PagingAndSortingRepository<Auditorium, Long> {
}
