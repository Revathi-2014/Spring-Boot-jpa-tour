package com.restapi.repository;

import com.restapi.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookingRepository extends JpaRepository<UserDetails, Long> {
}
