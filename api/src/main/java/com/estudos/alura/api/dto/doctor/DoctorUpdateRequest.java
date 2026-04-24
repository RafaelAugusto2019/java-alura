package com.estudos.alura.api.dto.doctor;

import com.estudos.alura.api.dto.address.AddressRegisterRequest;
import jakarta.validation.constraints.NotEmpty;

@NotEmpty
public record DoctorUpdateRequest(
        String name,
        String phoneNumber,
        AddressRegisterRequest addressRegisterRequest
) {
}
