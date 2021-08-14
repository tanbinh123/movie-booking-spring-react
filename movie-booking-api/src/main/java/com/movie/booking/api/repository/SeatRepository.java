package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Auditorium;
import com.movie.booking.api.entity.Seat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SeatRepository extends PagingAndSortingRepository<Seat,Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `seats` WHERE (`auditorium_id` = :id); ", nativeQuery = true)
    void deleteSeatsByAuditoriumId(@Param("id") Long id);
}
