package com.bank.service;


import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Landmark;
import com.bank.repositories.LandMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LandmarkService {
    private final LandMarkRepository landMarkRepository;

    public Landmark getById(Long id){
        return landMarkRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User with this id not found!"));
    }


    public List<Landmark> getAll(){
        return landMarkRepository.findAll();
    }


}
