package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Screening;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends PagingAndSortingRepository<Screening, Long> {
}
