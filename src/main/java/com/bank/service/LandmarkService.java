package com.bank.service;


import com.bank.dto.LandmarkDTO;
import com.bank.exceptions.BagRequestException;
import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Landmark;
import com.bank.repositories.LandmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LandmarkService {
    private final LandmarkRepository landMarkRepository;

    public Landmark getById(Long id){
        return landMarkRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Landmark with this id not found!"));
    }
    public Landmark getByTitle(String title){
        return landMarkRepository.findByTitle(title).orElseThrow(()
                 -> new ResourceNotFoundException("Landmark with this title not found!"));
    }

    public List<Landmark> getAll(){
        return landMarkRepository.findAll();
    }

    public List<Landmark> getAllByAddress(String address){
        return landMarkRepository.findAllByAddress_Address(address);
    }
    public List<Landmark> getAllByTitle(String address){
        return landMarkRepository.findAllByTitle(address);
    }

    @Transactional
    public void save(Landmark landmark){
        landMarkRepository.findByTitle(landmark.getTitle()).orElseThrow(()
                -> new BagRequestException("Landmark with this title already exists"));

    }

    @Transactional
    public void update(long id, Landmark updatedLandmark) {
        updatedLandmark.setId(id);
        landMarkRepository.save(updatedLandmark);
    }
}
