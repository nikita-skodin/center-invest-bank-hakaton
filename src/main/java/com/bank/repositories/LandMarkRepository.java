package com.bank.repositories;

import com.bank.models.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandMarkRepository extends JpaRepository<Landmark, Long> {
}
