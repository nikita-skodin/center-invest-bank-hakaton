package com.bank.repositories;

import com.bank.dto.EventDTO;
import com.bank.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventByTitle(String title);
}
