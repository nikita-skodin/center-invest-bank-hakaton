package com.bank.repositories;

import com.bank.models.ReviewEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewEventRepository extends JpaRepository<ReviewEvent, Long> {
}
