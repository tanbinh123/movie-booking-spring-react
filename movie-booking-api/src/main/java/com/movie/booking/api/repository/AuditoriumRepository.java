package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Auditorium;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AuditoriumRepository extends PagingAndSortingRepository<Auditorium, Long> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `auditoriums` WHERE (`id` = :id); ", nativeQuery = true)
    void deleteAuditoriumById(@Param("id") Long id);
}
