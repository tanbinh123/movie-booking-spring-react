package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
}
