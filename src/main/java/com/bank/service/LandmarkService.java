package com.bank.service;


import com.bank.dto.LandmarkDTO;
import com.bank.exceptions.BagRequestException;
import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Image;
import com.bank.models.Landmark;
import com.bank.repositories.LandmarkRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LandmarkService {
    private final LandmarkRepository landMarkRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final ImageService imageService;

    public Landmark getById(Long id){
        return landMarkRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Landmark with this id not found!"));
    }
    public Landmark getByTitle(String title){
        return landMarkRepository.findByTitle(title).orElseThrow(()
                 -> new ResourceNotFoundException("Landmark with this title not found!"));
    }

    public List<Landmark> getAll(){
        landMarkRepository.deleteAll();
        return landMarkRepository.findAll();
    }

    public List<Landmark> getAllByAddress(String address){
        return null;
    }
    public List<Landmark> getAllByTitle(String address){
        return landMarkRepository.findAllByTitle(address);
    }

    @Transactional
    public void save(Landmark landmark){
//        String address ="http://localhost:8080/spring-rest/foos"+ landmark.getAddress().getAddress();
//        RestTemplate restTemplate = new RestTemplate();
//
//        String json = restTemplate.getForObject(address, String.class);
//
//        try {
//            String coordinates = mapper.readTree(json).get("GeoObjectCollection").asText();
//            System.out.println(coordinates);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        landMarkRepository.findByTitle(landmark.getTitle()).orElseThrow(()
//                -> new BagRequestException("Landmark with this title already exists"));

    }

    @Transactional
    public void update(long id, Landmark updatedLandmark) {
        updatedLandmark.setId(id);
        landMarkRepository.save(updatedLandmark);
    }

    public List<Landmark> findAllByTitleStartingWith(String trim) {
        return landMarkRepository.findAllByTitleStartingWith(trim);
    }

    @Transactional
    public Landmark uploadImage(Long id, Image image) {
        Landmark landmark = getById(id);
        String imageName = imageService.upload(image);
        List<String> images = landmark.getImages();
        images.add(imageName);
        landmark.setImages(images);
        return landMarkRepository.save(landmark);
    }

    @Transactional
    public void deleteImage(Long id, String imageName){
        Landmark landmark = getById(id);
        List<String> images = landmark.getImages();
        if (!images.remove(imageName))
            throw new ResourceNotFoundException("Image with this name not found for this image");
        imageService.removeImage(imageName);
        landMarkRepository.save(landmark);
    }
}
