package com.estudos.alura.api.dto.patient;

import com.estudos.alura.api.dto.address.AddressRegisterRequest;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientRecordRequest(
        @NotBlank
        String cpf,
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Column(name = "phone_number")
        String phoneNumber,
        @NotNull
        @Valid
        AddressRegisterRequest address
) {
}
