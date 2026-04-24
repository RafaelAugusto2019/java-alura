package com.estudos.alura.api.doctor.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record AddressRegisterRequest(
        @NotBlank
        @Column(name = "addressLine1")
        String addressLine1,
        @Column(name = "addressLine2")
        String addressLine2,
        @NotBlank
        @Column(name = "district")
        String district,
        @Column(name = "zip_code")
        String zipCode,
        @NotBlank
        @Column(name = "state")
        String state,
        @NotBlank
        @Column(name = "city")
        String city) {

}
