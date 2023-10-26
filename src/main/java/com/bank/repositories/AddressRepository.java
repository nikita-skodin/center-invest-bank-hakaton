package com.bank.repositories;

import com.bank.dto.AddressDTO;
import com.bank.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Optional<AddressDTO> findByAddress(String address);
}
