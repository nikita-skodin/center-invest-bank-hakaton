package com.bank.repositories;

import com.bank.models.ReviewLandmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewLandmarkRepository extends JpaRepository<ReviewLandmark, Long> {
}
