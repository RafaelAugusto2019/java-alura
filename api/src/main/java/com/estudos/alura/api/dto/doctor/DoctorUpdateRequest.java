package com.estudos.alura.api.doctor.dto;

import jakarta.validation.constraints.NotEmpty;

@NotEmpty
public record DoctorUpdateRequest(
        String name,
        String phoneNumber,
        AddressRegisterRequest addressRegisterRequest
) {
}
