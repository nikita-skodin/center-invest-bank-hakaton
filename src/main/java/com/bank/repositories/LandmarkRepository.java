package com.bank.repositories;

import com.bank.models.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark,Long> {
    List<Landmark> findAllByAddress_Address(String address);
    List<Landmark> findAllByTitle(String title);
    Optional<Landmark> findByTitle(String title);
    List<Landmark> findAllByTitleStartingWith(String trim);
}
