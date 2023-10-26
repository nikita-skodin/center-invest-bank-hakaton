package com.bank.service;

import com.bank.exceptions.ResourceNotFoundException;
import com.bank.models.Address;
import com.bank.repositories.AddressRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO getAddressBy(String address){
        Optional<AddressDTO> optional= addressRepository.findAddress(address);
        return addressRepository.findAddress(address).orElseThrow(()
                -> new NotFoundException("Address with this id not found!"));
    }

    public void save (Address address){
        //TODO String KOORDINATI = getKoordinati;
        //KOORDINATI.setKOORDINATI()
    }


}
