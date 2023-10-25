package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Address;
import com.bank.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressService {
    private final AddressRepository addressRepository;

    public Address getById(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address with this id not found"));
    }

    public Address save(){
        return null;//TODO
    }
}
