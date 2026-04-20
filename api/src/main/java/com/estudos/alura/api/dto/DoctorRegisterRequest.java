package com.estudos.alura.api.dto;

import com.estudos.alura.api.enums.MedicalSpecialties;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRegisterRequest(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Column(name = "phone_number")
        String phoneNumber,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        MedicalSpecialties medicalSpecialties,
        @NotNull
        @Valid
        AddressRegisterRequest address) {
}
