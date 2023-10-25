package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.ReviewLandmark;
import com.bank.repositories.LandmarkRepository;
import com.bank.repositories.ReviewLandmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewLandmarkService {
    private final ReviewLandmarkRepository reviewLandmarkRepository;
    private final LandmarkRepository landmarkRepository;

    public ReviewLandmark getById(Long id){
        return reviewLandmarkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ReviewLandmark wiht this id not found!"));
    }

    public List<ReviewLandmark> getAll(){
        return reviewLandmarkRepository.findAll();
    }

    public void deleteById(Long id){
        getById(id);
        reviewLandmarkRepository.deleteById(id);
    }

    public ReviewLandmark save(ReviewLandmark reviewLandmark){

    }


}
