package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Event;
import com.bank.models.Image;
import com.bank.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventService {
    private final ImageService imageService;

    private final EventRepository eventRepository;
    private final AddressService addressService;

    public List<Event> getAll() {
        eventRepository.deleteAllByStartTimeAfter(Instant.now());
        return eventRepository.findAll();
    }

    public Event getById(Long aLong) {
        return eventRepository.findById(aLong)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public Optional<Event> getEventByTitle(String title) {
        return eventRepository.findEventByTitle(title);
    }

    @Transactional
    public Event update(Long id, Event entity) {
        Event event = getById(id);

        entity.setId(event.getId());
        entity.setCoordinates(addressService.getCoordinatesByAddress(entity.getAddress()));
        return eventRepository.save(entity);
    }

    @Transactional
    public <S extends Event> S save(S entity) {
        entity.setCoordinates(addressService.getCoordinatesByAddress(entity.getAddress()));
        return eventRepository.save(entity);
    }

    @Transactional
    public void deleteById(Long aLong) {
        eventRepository.deleteById(aLong);
    }

    public List<Event> findAllByTitleStartingWith(String trim) {
        return eventRepository.findAllByTitleStartingWith(trim);
    }

    @Transactional
    public Event uploadImage(Long id, Image image) {
        Event event = getById(id);
        String imageName = imageService.upload(image);
        List<String> images = event.getImages();
        images.add(imageName);
        event.setImages(images);
        return eventRepository.save(event);
    }

    @Transactional
    public void deleteImage(Long id, String imageName){
        Event event = getById(id);
        List<String> images = event.getImages();
        if (!images.remove(imageName))
            throw new ResourceNotFoundException("Image with this name not found for this image");
        imageService.removeImage(imageName);
        eventRepository.save(event);
    }
}
