package com.movie.booking.api.repository;

import com.movie.booking.api.entity.Role;
import com.movie.booking.api.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(RoleEnum role);
}