package com.bank.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "country")
    @NotNull
    private String country;

    @Column(name = "city")
    @NotNull
    private String city;

    @NotNull
    @Column(name="street")
    private String street;



}
