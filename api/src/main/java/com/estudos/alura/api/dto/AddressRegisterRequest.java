package com.estudos.alura.api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record AddressRegisterRequest(
        @Column(name = "addressLine1")
        String addressLine1,
        @Column(name = "addressLine2")
        String addressLine2,
        @Column(name = "district")
        String district,
        @Column(name = "zip_code")
        String zipCode,
        @Column(name = "state")
        String state,
        @Column(name = "city")
        String city) {
}
