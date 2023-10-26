package com.bank.repositories;

import com.bank.models.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark,Long> {
    List<Landmark> findAllByTitle(String title);
    Optional<Landmark> findByTitle(String title);
    Optional<Landmark> findByAddress(String title);
    List<Landmark> findAllByTitleStartingWith(String trim);
    Optional<Landmark> findLandmarksByTitle(String title);
}
