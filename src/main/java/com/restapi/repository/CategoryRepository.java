package com.restapi.repository;

import com.restapi.model.TourCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<TourCategory, Long> {
}
