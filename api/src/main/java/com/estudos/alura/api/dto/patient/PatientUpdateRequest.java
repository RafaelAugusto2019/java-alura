package com.estudos.alura.api.dto.patient;

import com.estudos.alura.api.dto.address.AddressRegisterRequest;
import jakarta.validation.constraints.NotEmpty;

@NotEmpty
public record PatientUpdateRequest(
        String name,
        String phoneNumber,
        AddressRegisterRequest address
) {
}
