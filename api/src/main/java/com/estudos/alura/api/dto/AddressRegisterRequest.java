package com.estudos.alura.api.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public record AddressRegisterRequest(
        String addressLine1,
        String addressLine2,
        String district,
        String zipCode,
        String city,
        String state) {

}
